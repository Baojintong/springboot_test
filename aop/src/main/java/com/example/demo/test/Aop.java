package com.example.demo.test;

//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

//@Aspect
public class Aop {

//    private Map<String,Integer> codeCount=new HashMap<>();
//
//    @Pointcut("execution(* com.example.demo.test.Test.giveMeCode(String))&&args(code)")
//    public void pointcut(String code){}
//
//    @Bean
//    public Aop Aop() {
//        return new Aop();
//    }
//
//    @Before("pointcut(code)")
//    public void setCountCode(String code){
//        System.out.println("在切点之前执行设置code"+code);
//        int count=getCountCode(code);
//        codeCount.put(code,++count);
//
//    }
//
//    public int getCountCode(String code){
//        return codeCount.get(code)!=null?codeCount.get(code):0;
//    }
//
//    @DeclareParents(value = "com.example.demo.test.Test+",defaultImpl =ImpleNewTest.class )
//    public static NewTest newTest;
}
