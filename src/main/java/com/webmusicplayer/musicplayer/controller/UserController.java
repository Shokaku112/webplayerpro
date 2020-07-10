package com.webmusicplayer.musicplayer.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.webmusicplayer.musicplayer.annotation.UserLoginToken;
import com.webmusicplayer.musicplayer.domain.User;
import com.webmusicplayer.musicplayer.service.TokenService;
import com.webmusicplayer.musicplayer.service.impl.UserServiceImpl;
import com.webmusicplayer.musicplayer.util.TokenUtil;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.parser.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
//@Controller
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TokenService tokenService;




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

//    @RequestMapping(value = "/user/getuser",method = RequestMethod.GET)
//    //@ResponseBody
//    //@CrossOrigin("http://localhost:8080")
//    public Object getUser(@RequestParam("username") String name,@RequestParam("userpwd") String password){
//        System.out.println("username:"+name);
//        System.out.println("password:"+password);
//        User user=userService.getUser(name,password);
//        System.out.println(user);
//        JSONObject result = new JSONObject();
//        if(user!=null){
//            result.put("Username",user.getUserName());
//            result.put("Userpwd",user.getPassword());
//            result.put("statusCode",1);
//            //result.put("data",user);
//        }
//        else{
//            result.put("statusCode",-1);
//        }
//        return result;
//    }

    //@UserLoginToken
//    @ApiOperation(value = "登录")
//    @RequestMapping(value = "/user/getuser",method = RequestMethod.GET)
//    public Object login(@RequestParam("username") String userName, @RequestParam("userpwd") String password, @RequestParam("token") String token, HttpServletResponse response){
//        System.out.println("login");
//        JSONObject jsonObject=new JSONObject();
//        User user = userService.getUser(userName, password);
//        if(user==null){
//            //jsonObject.put("message","登录失败，密码错误");
//            jsonObject.put("statusCode",-1);
//            return jsonObject;
//        }
//        else{
//            String token=tokenService.getToken(user);
//            System.out.println("UserController__token:"+token);
//            jsonObject.put("token",token);
//            jsonObject.put("statusCode",1);
//            jsonObject.put("Userimg",user.getImgUrl());
//            jsonObject.put("Username",user.getUserName());
//            jsonObject.put("Userpassword",user.getPassword());
//
//            Cookie cookie=new Cookie("token",token);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//
//            //response.setHeader("token",token);
//
//            return jsonObject;
//        }
//    }

//    @ApiOperation(value = "登录")
//    @RequestMapping(value = "/user/getuser",method = RequestMethod.GET)
//    public Object login(@RequestParam("username") String userName,@RequestParam("userpwd") String password,@RequestParam("token") String token,HttpServletResponse response){
//        System.out.println("userName = " + userName);
//        System.out.println("password = " + password);
//        System.out.println("token = " + token);
//        System.out.println("login");
//        JSONObject jsonObject=new JSONObject();
//        User user = userService.getUser(userName, password);
//        if(user==null){
//            //jsonObject.put("message","登录失败，密码错误");
//            jsonObject.put("statusCode",-1);
//            return jsonObject;
//        }
//        else{
//            System.out.println("user is not null,and the token is "+token);
//            System.out.println("token=="+token);
//            if(token.equals("null")||token.equals("")){
//                System.out.println("111111111111");
//                token=tokenService.getToken(user);
//                System.out.println("222222222222");
//                System.out.println("token==="+token);
//                Cookie cookie=new Cookie("token",token);
//                cookie.setPath("/");
//                response.addCookie(cookie);
//            }
//            System.out.println("UserController_login_token:"+token);
//            jsonObject.put("token",token);
//            jsonObject.put("statusCode",1);
//            jsonObject.put("Userimg",user.getImgUrl());
//            jsonObject.put("Username",user.getUserName());
//            jsonObject.put("Userpassword",user.getPassword());
//
//
//
//            //response.setHeader("token",token);
//
//            return jsonObject;
//        }
//    }


    //@UserLoginToken
//    @RequestMapping(value = "/user/getuser")
//    public Object loginOnlyToken(@RequestParam("token") String token){
//        System.out.println("loginOnlyToken");
//        System.out.println(token);
//        if(token.equals("null")||token.equals("")){
//            return null;
//        }
//        else{
//            System.out.println("UserController__token:"+token);
//            JSONObject jsonObject=new JSONObject();
//            String userName= JWT.decode(token).getAudience().get(0);
//            User user = userService.findUserByName(userName);
//            jsonObject.put("Userimg",user.getImgUrl());
//            jsonObject.put("Username",user.getUserName());
//            return jsonObject;
//        }
//
//
//
//    }

//    @RequestMapping(value = "/user/getuser")
//    public void loginOnlyToken(@RequestParam("token") String token){
//        System.out.println("loginOnlyToken");
//
//        System.out.println(token);
//
//    }



//    @UserLoginToken
//    @RequestMapping(value = "#/player")
//    public Object player(@RequestParam("token") String token){
//        System.out.println("player");
//        return loginOnlyToken(token);
//    }

    //@UserLoginToken
//    @RequestMapping(value = "#/player")
//    public void player(@RequestParam("token") String token){
//        System.out.println("player");
//        //return loginOnlyToken(token);
//    }


    //@ApiOperation(value = "登录")
    @RequestMapping(value = "/user/getuser",method = RequestMethod.GET,params = {"username","userpwd","token"})
    public Object login(@RequestParam("username") String userName,@RequestParam("userpwd") String password,@RequestParam("token") String token,HttpServletResponse response){
        System.out.println("you are in login method");
        System.out.println("userName = " + userName);
        System.out.println("password = " + password);
        System.out.println("token = " + token);

        JSONObject jsonObject=new JSONObject();
        User user = userService.getUser(userName, password);
        if(user==null){
            //jsonObject.put("message","登录失败，密码错误");
            jsonObject.put("statusCode",-1);
            return jsonObject;
        }
        else {
            System.out.println("user is not null,and the token is " + token);
            System.out.println("token==" + token);
            if (token.equals("null") || token.equals("")) {
                token = tokenService.getToken(user);
                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            System.out.println("UserController_login_token:" + token);
            jsonObject.put("token", token);
            jsonObject.put("statusCode", 1);
            jsonObject.put("Userimg", user.getImgUrl());
            jsonObject.put("Username", user.getUserName());
            jsonObject.put("Userpassword", user.getPassword());


            //response.setHeader("token",token);

            return jsonObject;
        }

    }

    @RequestMapping(value = "/user/getuser",method = RequestMethod.GET,params = "token")
    public Object loginOnly(@RequestParam("token") String token){
        System.out.println("you are in loginOnly method");
        System.out.println("token = " + token);
        if(token.equals("null")||token.equals("")){
            return null;
        }
        else{
            System.out.println("UserController__token:"+token);
            JSONObject jsonObject=new JSONObject();
            String userName= JWT.decode(token).getAudience().get(0);
            User user = userService.findUserByName(userName);
            jsonObject.put("Userimg",user.getImgUrl());
            jsonObject.put("Username",user.getUserName());
            return jsonObject;
        }
    }



    /**
     * 这个请求需要验证token才能访问
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/getMessage",method = RequestMethod.GET)
    public String getMessage(){
        //取出token中自带的用户userName进行操作
        System.out.println(TokenUtil.getTokenUserName());

        return "您已通过验证";
    }

    @RequestMapping(value = "/showData",method = RequestMethod.GET)
    public String showData(@RequestParam("name") String tips){
        return tips;
    }

//    @UserLoginToken()
//    @RequestMapping(value = "/player")
//    public Object player(){
//        System.out.println("player");
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("Username",userName);
//        jsonObject.put("Userimg",imgUrl);
//        //
//
//    }


}
