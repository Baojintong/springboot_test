package com.example.demo.test;

import org.springframework.stereotype.Component;

@Component("test")
public class ImplementsTest implements Test{
    @Override
    public void test() {
        System.out.println("test");
    }

    @Override
    public void giveMeCode(String code) {
        System.out.println("my code is "+code);
    }
}
