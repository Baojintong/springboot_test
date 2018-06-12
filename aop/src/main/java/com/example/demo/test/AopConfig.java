package com.example.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy//启用自动代理
@ComponentScan
public class AopConfig {
//    @Bean
//    public Aop Aop() {
//        return new Aop();//声明bean
//    }
//    @Bean(name = "NewAop")
//    public NewAop newAop() {
//        return new NewAop();//声明bean
//    }

}
