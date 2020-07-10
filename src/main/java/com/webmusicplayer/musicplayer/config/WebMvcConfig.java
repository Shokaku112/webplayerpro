package com.webmusicplayer.musicplayer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                .allowedHeaders("*")
                //设置允许的方法
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                //.allowedMethods("*")
                //是否允许证书
                .allowCredentials(true)
                //跨域允许时间
                .maxAge(3600);
    }
}
