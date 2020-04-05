package com.efss.service;

import com.efss.entity.user.User;
import com.efss.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private UserMapper userMapper;

    public List<User> hellowSelectUser(){
        return userMapper.hellowSelectUser();
    }

}
