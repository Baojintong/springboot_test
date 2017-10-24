package com.book.demo.controller;

import com.book.demo.dao.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BookMapper bookMapper;

    @RequestMapping(value = "/Book",method = RequestMethod.GET)
    public String index(String name) {
        System.out.println(name);
        Map m=new HashMap<String,String>();
        m.put("name",name);
        System.out.println(bookMapper.findBookByName(m));
        return "Book";
    }
}
