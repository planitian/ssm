package com.plani.controller;


import com.plani.dao.UserDao;
import com.plani.model.User;
import com.plani.service.UserService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")//类级别的  根目录
public class UserController {
    //日志
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @GetMapping("/findAll")//方法级别
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        userList.forEach(user -> {
            System.out.println(user.getId());
            System.out.println(user.getName());
        });
        log.debug("哈哈哈哈");
        User user = new User();
        user.setName("添加");
        user.setPassword("1234");
        User one = new User();
        user.setName("selectKey");
        user.setPassword("1234");

        User two = new User();
        two.setName("小猪猪");
        try {
            Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = factory.openSession();
            UserDao dao = sqlSession.getMapper(UserDao.class);
            System.out.println("数据库 插入数据  数据库自增主键 "+dao.add(user));
            System.out.println("数据库  插入数据  seleckey "+dao.addIDmyself(one));
            dao.romove(1);
            System.out.println(dao.updateUser(two));
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        User three = new User();
        three.setName("spring添加");
        three.setPassword("1234");
        userService.addIDmyself(three);
        model.addAttribute("java", "后台");
        return "hello";
    }


    @RequestMapping(value = "/searc",method = RequestMethod.GET)
    public String re(@RequestParam("id") Integer id, Model model){
        log.debug("id "+id);
        User user = userService.find(id);
        if (user!=null){
            model.addAttribute(user);
        }
        return "hello";
    }
    @RequestMapping(value = "/find/{id}" ,method = RequestMethod.GET)
    public String ba(@PathVariable("id")Integer id, Map<String,Object> model){
        log.debug("id "+id);
        User user = userService.find(id);
        if (user!=null){
            model.put("key",user);
        }
        return "hello";
    }
    @GetMapping("/test")
    public String test(@RequestParam("name") String name,@RequestParam String password,Model model){
        System.out.println(name+password+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        User user = userService.test(name, password);
        if (user!=null){
            model.addAttribute(user);
        }
        return "hello";
    }

    //有两种接受前端数据的方式，一种使用Map接受，一种使用实体类进行接收，
    @ResponseBody
    @GetMapping("/json")
    public User backJson(){
        return new User("baying","蠢猪");
    }
    //第二种返回json方式
    @RequestMapping(value = "/jsonOne",method = RequestMethod.GET)
    public ResponseEntity<User> backJsonOne(){
        log.debug("进入这个方法了");
        return new ResponseEntity<User>(new User("baying", "蠢猪"), HttpStatus.OK);
    }

    @GetMapping("/one")
    public String test(String id,Model model) {
       /* ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("java", "test");*/
        model.addAttribute(new User("key", "ss"));
        return "test";
    }
}
