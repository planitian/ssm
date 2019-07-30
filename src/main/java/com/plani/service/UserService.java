package com.plani.service;

import com.plani.dao.UserDao;
import com.plani.model.User;

import java.util.List;

public interface UserService  {
    List<User> findAll();
    int addIDmyself(User user);

    User find(Integer id);

    User test(String name, String password);
}
