package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时任务
public class DemoApplication {
    public static String name="";
    public static void main(String[] args) {
        name=args[0];
        SpringApplication.run(DemoApplication.class, args);
    }
}
