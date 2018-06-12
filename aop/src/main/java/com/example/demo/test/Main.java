package com.example.demo.test;

import com.example.demo.DemoApplication;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AopConfig.class);
        //ImplementsTest implementsTest= (ImplementsTest) applicationContext.getBean("implementsTest");
        ImplementsTest implementsTest=(ImplementsTest)applicationContext.getBean("test");
        implementsTest.test();
        //ImpleNewTest impleNewTest= (ImpleNewTest) implementsTest;
        //impleNewTest.newMethod();
    }
}
