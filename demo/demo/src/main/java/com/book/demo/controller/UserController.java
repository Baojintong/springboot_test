package com.book.demo.controller;

import com.book.demo.domain.Controller;
import com.book.demo.domain.HelloService;
import com.book.demo.domain.TestCondition;
import com.book.demo.util.RedisUtils;
import org.hibernate.engine.jdbc.ReaderInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import com.book.demo.dao.UserMapper;

import java.io.*;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/User")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper dao;
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String query(String username,String password) {
        HashMap map=new HashMap();
        map.put("username",username);
        map.put("password",password);
        Integer i=dao.login(map);
        return i>0?"{\"msg\":\"true\"}":"{\"msg\":\"false\"}";
    }

    @RequestMapping(value = "/SaveBook", method = RequestMethod.GET)
    public Integer save() {
        //ApplicationContext ac=new AnnotationConfigApplicationContext("domain");
        //System.out.println(SpringUtil.getBean("book"));//Book{num=1, name='java核心技术', money=20}
        //ApplicationContext ac=new AnnotationConfigApplicationContext((new StudentConfig()).getClass());
        //System.out.println(ac.getBean("book"));//Book{num=1, name='java核心技术', money=20}
        ApplicationContext ac=new AnnotationConfigApplicationContext("com.book.demo.domain");//当然通过Spring实战里面学到的方式也是可以得
        System.out.println(ac.getBean("sss"));//Book{num=1, name='java核心技术', money=20}
        return 10;
    }

    @RequestMapping("/auto/home")
    public String home(){
        return helloService.say();
    }

}
