package com.plani.dao;

import com.plani.bean.Plani;
import com.plani.model.One;
import com.plani.model.TestEnmu;
import com.plani.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    List<User> findAll();

    int add(User user);

    int addIDmyself(User user);

    void romove(Integer id);

    @Update("UPDATE user SET name =#{name} WHERE name = '巴莹'")
    int updateUser(User user);

    @Select("Select *  FROM user where id=#{id}")
    User find(Integer id);

    User test(@Param("name") String name, @Param("password") String password);

    Plani findTest();

    List<Map<String, Object>> findMap();

    void insertUser(User user);

    TestEnmu findEnmu(Integer id);

     Integer  insertEnmu(TestEnmu testEnmu);

}
