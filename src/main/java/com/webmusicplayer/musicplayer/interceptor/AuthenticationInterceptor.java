package com.webmusicplayer.musicplayer.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.webmusicplayer.musicplayer.annotation.PassToken;
import com.webmusicplayer.musicplayer.annotation.UserLoginToken;
import com.webmusicplayer.musicplayer.domain.User;
import com.webmusicplayer.musicplayer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * 拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从http请求取出cookies
//        Cookie[] cookies = request.getCookies();
//        System.out.println("输出cookie中...");
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie);
//        }
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
//            response.setStatus(HttpServletResponse.SC_OK);
//            return false;
//        }


//        if (request.getMethod().equals("OPTIONS")){
//            //log.info("浏览器的预请求的处理..");
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
//            response.setHeader("Access-Control-Max-Age", "3600");
//            response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
//            return false;
//        }



        //Cookie[] cookies = request.getCookies();
        //System.out.println("cookies"+cookies.toString());
        // 从http请求头中取出token
//        String token=request.getHeader("token");
        String token="";
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    token = cookie.getValue();
                }
            }
        }
        if(token==""){
            token=request.getHeader("token");
        }
        //String token=request.getHeader("token");
        //Enumeration<String> headerNames = request.getHeaderNames();
        //System.out.println("HeaderNames...");
        //System.out.println(headerNames);
        System.out.println("AuthenticationInterceptor__PreHandle:"+token);
        //如果不是映射到方法直接通过
        System.out.println("handler = " + handler);
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod= (HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken=method.getAnnotation(PassToken.class);
            if (passToken.required()){
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken=method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){
                //执行认证
                if (token==null){
                    throw new RuntimeException("无token，请重新登录！");
                    //return true;
                }
                //获取token中的userName
                String userName;
                try{
                    userName= JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException j){
                    throw new RuntimeException("401");
                }
                User user=userService.findUserByName(userName);
                if (user==null){
                    throw new RuntimeException("用户不存在，请重新登录！");
                }
                //验证token
                JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
