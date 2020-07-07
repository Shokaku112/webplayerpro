package com.webmusicplayer.musicplayer.service.impl;

import com.webmusicplayer.musicplayer.dao.IUserDao;
import com.webmusicplayer.musicplayer.domain.User;
import com.webmusicplayer.musicplayer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@ComponentScan(basePackages = {"com.webmusicplayer.musicplayer.dao.IUserDao"})
public class UserServiceImpl implements IUserService {

    //@Autowired(required = false)
    @Autowired(required = false)
    private IUserDao userDao;

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public User getUser(String name, String password) {
        return userDao.getUser(name,password);
    }
}
