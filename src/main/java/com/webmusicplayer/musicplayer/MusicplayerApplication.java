package com.webmusicplayer.musicplayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@MapperScan("com.webmusicplayer.musicplayer.dao")
@SpringBootApplication
public class MusicplayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicplayerApplication.class, args);
    }

}
