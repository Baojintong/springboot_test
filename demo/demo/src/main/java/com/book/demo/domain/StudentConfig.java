package com.book.demo.domain;

import com.book.demo.condition.MyCondition;
import com.book.demo.domain.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@Conditional(MyCondition.class)
public class StudentConfig {

    //声明一个bean
    @Bean
    public Book sss(){
        Book b=new Book(1,"java核心技术",new BigDecimal(20),"");
        System.out.println(b);
        return b;
    }
}
