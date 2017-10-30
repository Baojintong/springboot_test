package com.book.demo.controller;

import com.book.demo.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.book.demo.dao.UserMapper;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/User")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper bookMapper;

    @Autowired
    RedisUtils ru;

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public List query(String username,String password) {
        HashMap map=new HashMap();
        map.put("username",username);
        map.put("password",password);
        System.out.println(username+"------"+password);
        return null;
    }

    @RequestMapping(value = "/SaveBook", method = RequestMethod.GET)
    public Integer save() {
        HashMap map=new HashMap();
        map.put("name","1");
        map.put("age","12");
        System.out.println(ru.set("map",map));//true
        System.out.println(ru.get("map"));//{name=1, age=12}
        return 10;
    }

}
