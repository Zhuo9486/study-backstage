package com.zhuo.study.dao;

import com.zhuo.study.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao extends JpaRepository<User, Integer> {

    //test
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

}
