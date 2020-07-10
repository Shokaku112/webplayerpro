package com.webmusicplayer.musicplayer.util;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class TokenUtil {

    public static String getTokenUserName(){
        //从http请求头中取出
        String token="";
        Cookie[] cookies = getRequest().getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    token = cookie.getValue();
                }
            }
        }
        if(token==""){
            token=getRequest().getHeader("token");
        }
        //String token=getRequest().getHeader("token");
//        Cookie[] cookies = getRequest().getCookies();
//        System.out.println("输出cookie中...");
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie);
//        }
        System.out.println("TokenUtil__token:"+token);
        String userName= JWT.decode(token).getAudience().get(0);
        System.out.println("TokenUtil__userName:"+userName);
        return userName;
    }

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes==null?null:requestAttributes.getRequest();
    }
}
