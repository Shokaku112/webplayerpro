package com.webmusicplayer.musicplayer.dao;

import com.webmusicplayer.musicplayer.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//@Repository
@Mapper
public interface IUserDao {

    /**
     * 查找全部用户
     * @return
     */
    @Select("select * from user")
    List<User> findAllUser();

    /**
     * 通过用户名查找单个用户
     * @param name
     * @return
     */
    @Select("select * from user where name=#{name}")
    User findUserByName(String name);

    /**
     * 判断登录
     * @param name
     * @param password
     * @return
     */
    @Select("select * from user where name=#{0} and password=#{1}")
    User getUser(String name,String password);

}
