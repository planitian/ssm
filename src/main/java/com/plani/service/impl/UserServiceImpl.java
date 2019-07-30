package com.plani.service.impl;

import com.plani.dao.UserDao;
import com.plani.model.User;
import com.plani.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int addIDmyself(User user) {

        return userDao.add(user);
    }

    @Override
    public User find(Integer id) {
        return userDao.find(id);
    }


    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
    public User test(String name, String password) {
        return userDao.test(name,password);
    }
}
