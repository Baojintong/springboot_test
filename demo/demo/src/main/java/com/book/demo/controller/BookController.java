package com.book.demo.controller;

import com.book.demo.dao.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BookMapper bookMapper;

    @RequestMapping(value = "/Book", method = RequestMethod.GET)
    public List query(String name,String page,String size) {
        Map m = new HashMap<String, String>();
        if ("undefined".equals(name)) {
            m.put("name", "");
        }else{
            m.put("name", name);
        }
        System.out.println(name+"----"+page+"----"+size);
        m.put("page", (Integer.parseInt(page))*Integer.parseInt(size));
        m.put("size", Integer.parseInt(size));
        List i = bookMapper.findBookByName(m);
        return i;
    }

    @RequestMapping(value = "/SaveBook", method = RequestMethod.GET)
    public Integer save(String name, String money) {
        Map m = new HashMap<String, String>();
        m.put("name", name);
        m.put("money", money);
        return bookMapper.saveBook(m);
    }

}
