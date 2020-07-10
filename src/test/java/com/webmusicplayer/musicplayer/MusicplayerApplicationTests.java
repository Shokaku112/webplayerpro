package com.webmusicplayer.musicplayer;

import com.webmusicplayer.musicplayer.dao.IUserDao;
import com.webmusicplayer.musicplayer.domain.User;
import com.webmusicplayer.musicplayer.service.IUserService;
import com.webmusicplayer.musicplayer.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Component
class MusicplayerApplicationTests {

    @Resource
    private IUserDao userDao;

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAllUser(){
        //List<User> users=userService.findAllUser();
        List<User> users=userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testFindUserByName(){
        User user=userService.findUserByName("Normalife");
        System.out.println(user);
    }

    @Test
    void testGetUser(){
        User user=userService.getUser("Normalife","456");
        System.out.println(user);
    }



    @Test
    void testSave(){
        User user=new User();
        user.setUserName("Lbb");
        user.setPassword("123456");
        if(userDao.findUserByUserName(user.getUserName())==null){
            userDao.registerUser(user);
        }
        else{
            System.out.println("当前用户名已存在");
        }

    }

    @Test
    void testUpdate(){
        User user=userDao.findUserByUserName("Lbb");
        user.setSex("男");
        userDao.updateUser(user);
    }

}
