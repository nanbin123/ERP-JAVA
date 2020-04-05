package com.efss.controller;

import com.efss.entity.user.User;
import com.efss.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {


    @Autowired
    private HelloService hellowService;


    @RequestMapping("say")
    @ResponseBody
    public  List<User> say(){
        List<User> list= hellowService.hellowSelectUser();
        return list;
    }




}
