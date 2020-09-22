package com.example.demo.controller;

import com.example.demo.config.PeopleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestHello {

    @Autowired
    PeopleConfig peopleConfig;

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return peopleConfig.toString();
    }
}
