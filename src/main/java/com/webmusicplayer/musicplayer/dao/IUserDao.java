package com.webmusicplayer.musicplayer.dao;

import com.webmusicplayer.musicplayer.domain.User;
import org.apache.ibatis.annotations.*;
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
    @Results(id="userMap",value = {
            @Result(id = true, column = "user_name", property = "userName"),
            @Result(column = "password", property = "password"),
            @Result(column = "real_name", property = "realName"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "email", property = "email"),
            @Result(column = "personal_signature", property = "personalSignature"),
            @Result(column = "img_url", property = "imgUrl")
    })
    List<User> findAllUser();

    /**
     * 通过用户名查找单个用户
     * @param userName
     * @return
     */
    @Select("select * from user where user_name=#{0}")
    @ResultMap("userMap")
    User findUserByUserName(String userName);

    /**
     * 判断登录
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from user where user_name=#{0} and password=#{1}")
    @ResultMap("userMap")
    User getUser(String userName,String password);

    @Update("update user set password=#{password},img_url=#{imgUrl},real_name=#{realName},email=#{email},sex=#{sex},personal_signature=#{personalSignature} where user_name=#{userName}")
    @ResultMap("userMap")
    void updateUser(User user);

    @Insert("insert into user(user_name,password,real_name,email,sex,personal_signature,img_url) values (#{userName},#{password},#{realName},#{email},#{sex},#{personalSignature},#{imgUrl})")
    @ResultMap("userMap")
    void registerUser(User user);

}
