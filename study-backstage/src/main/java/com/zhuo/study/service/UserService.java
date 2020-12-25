package com.zhuo.study.service;

import com.zhuo.study.dao.userDao;
import com.zhuo.study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    userDao userDao;

    public boolean isExist(String username){
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username){

        return userDao.findByUsername(username);
    }

    public User get(String username, String password){

        return userDao.getByUsernameAndPassword(username,password);
    }

    public void add(User user){

        userDao.save(user);
    }
}
