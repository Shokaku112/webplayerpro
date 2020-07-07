package com.webmusicplayer.musicplayer;

import com.webmusicplayer.musicplayer.dao.IUserDao;
import com.webmusicplayer.musicplayer.domain.User;
import com.webmusicplayer.musicplayer.service.IUserService;
import com.webmusicplayer.musicplayer.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootTest
@Component
class MusicplayerApplicationTests {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAllUser(){
        List<User> users=userService.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testFindUserByName(){
        User user=userService.findUserByName("小红");
        System.out.println(user);
    }

    @Test
    void testGetUser(){
        User user=userService.getUser("Mary","123456");
        System.out.println(user);
    }

    @Test
    void testGetUserByDao(){

        User user=userDao.getUser("Mery","123456");
        System.out.println(user);
    }

}
