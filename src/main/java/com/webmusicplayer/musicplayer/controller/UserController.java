package com.webmusicplayer.musicplayer.controller;

import com.alibaba.fastjson.JSONObject;
import com.webmusicplayer.musicplayer.domain.User;
import com.webmusicplayer.musicplayer.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/findAllUser")
    public Object findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    public Object findUserByName(@RequestParam("name") String name){
        JSONObject result=new JSONObject();
        User user=userService.findUserByName(name);
        result.put("user",user);
        return result;
        //return userService.findUserByName(name);
    }

    @RequestMapping(value = "/user/getuser",method = RequestMethod.GET)
    @ResponseBody
    //@CrossOrigin("http://localhost:8080")
    public Object getUser(@RequestParam("username") String name,@RequestParam("userpwd") String password){
        System.out.println("username:"+name);
        System.out.println("password:"+password);
        User user=userService.getUser(name,password);
        System.out.println(user);
        JSONObject result = new JSONObject();
        if(user!=null){
            result.put("Username",user.getName());
            result.put("Userpwd",user.getPassword());
            result.put("statusCode",1);
            //result.put("data",user);
        }
        else{
            result.put("statusCode",-1);
        }
        return result;
    }




    @RequestMapping(value = "/showData",method = RequestMethod.GET)
    public String showData(@RequestParam("name") String tips){
        return tips;
    }


}
