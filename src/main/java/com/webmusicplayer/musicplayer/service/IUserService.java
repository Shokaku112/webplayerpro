package com.webmusicplayer.musicplayer.service;

import com.webmusicplayer.musicplayer.domain.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();

    User findUserByName(String name);

    User getUser(String name,String password);
}
