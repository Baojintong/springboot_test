package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.req.RequestParams;
import com.example.demo.resp.RespObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    CustomerMapper customerMapper;

    @RequestMapping("/add")
    @ResponseBody
    public RespObject add(RequestParams params, BindingResult errors) {
        Customer customer = new Customer();
        customer.setCustomerName("大牛");
        customer.setGender("男");
        customer.setTelephone("66566");
        customerMapper.insert(customer);
        return new RespObject("success", params.getName() + ":" + params.getAge());
    }

    @RequestMapping("/update")
    @ResponseBody
    public RespObject update(RequestParams params, BindingResult errors) {
        Customer customer = new Customer();
        customer.setId(26L);
        customer.setCustomerName("大牛哥");
        customer.setGender("男");
        customer.setTelephone("66566-1");
        customerMapper.updateById(customer);
        return new RespObject("success", params.getName() + ":" + params.getAge());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public RespObject delete(RequestParams params, BindingResult errors) {
        customerMapper.deleteById(27L);
        return new RespObject("success", params.getName() + ":" + params.getAge());
    }

    @RequestMapping("/selectByWrapper")
    @ResponseBody
    public List<Customer> selectByWrapper(RequestParams params, BindingResult errors) {
        // 条件封装
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.eq("id",26L);
        List<Customer> customers = customerMapper.selectList(wrapper);
        // [Customer(id=26, customerName=大牛哥, gender=男, telephone=66566, registerTime=null)]
        System.out.println(customers);
        return customers;//new RespObject("success", params.getName() + ":" + params.getAge());
    }

    @RequestMapping("/page")
    @ResponseBody
    public IPage<Customer> page(RequestParams params, BindingResult errors) {
        Page<Customer> page = new Page<>(1, 2);
        IPage<Customer> customerPage = customerMapper.selectPage(page, null);
        System.out.println(customerPage);
        return customerPage;//new RespObject("success", params.getName() + ":" + params.getAge());
    }
}
