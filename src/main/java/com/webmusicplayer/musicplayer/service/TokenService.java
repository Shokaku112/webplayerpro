package com.webmusicplayer.musicplayer.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.webmusicplayer.musicplayer.domain.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    public String getToken(User user){
        Date start=new Date();
        long currentTime=System.currentTimeMillis()+60*60*1000;//一小时有效时间
        Date end=new Date(currentTime);
        String token="";
        token= JWT.create()
                .withAudience(user.getUserName())
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        System.out.println("TokenService__token:"+token);
        return token;
    }
}
