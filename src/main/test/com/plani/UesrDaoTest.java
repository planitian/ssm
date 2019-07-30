package com.plani;

import com.plani.bean.Plani;
import com.plani.bean.Ty;
import com.plani.bean.Type;
import com.plani.dao.UserDao;
import com.plani.model.*;
import com.plani.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class UesrDaoTest {

     //注意 这个注解
    @Autowired
    private UserDao userDao;

    @Test
    public void test() {

        //下面注释代码 可以起作用  该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//       UserDao userDao=(UserDao) applicationContext.getBean("userDao");

        TestEnmu testEnmu = new TestEnmu();
        testEnmu.setType(Type.Two);
        userDao.insertEnmu(testEnmu);

    }


}
