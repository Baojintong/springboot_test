package com.book.demo;

import com.book.demo.domain.HelloAutoConfiguration;
import com.book.demo.domain.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//开启Spring集成测试支持
@ContextConfiguration(classes = HelloAutoConfiguration.class)//指定上下文配置
@SpringBootTest//加入这个注解在测试环境下才会加载所有配置
public class TestMethod {
    @Autowired
    private HelloService he;

    @Test
    public void run(){
        System.out.println(he.say());//hello world
    }
}
