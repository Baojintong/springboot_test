package com.example.demo.test;

import org.springframework.stereotype.Component;

@Component
public class ImpleNewTest implements NewTest {
    @Override
    public void newMethod() {
        System.out.println("这是新加入的方法");
    }
}
