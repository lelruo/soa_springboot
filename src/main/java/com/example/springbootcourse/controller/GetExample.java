package com.example.springbootcourse.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @ClassNameGetExample
 * @Description TODO
 * @Author86182
 * @Date2021/11/1510:37
 * @Version 1.0
 **/
//将这个类变成可以接受API测试的类
//    springboot:全注解框架
//    全注解：只要用注解就可以把这个类和其他类区别开
//    api
@RestController
//api请求的路径
@RequestMapping("api/v1/get")
public class GetExample {
//api 规则

    @RequestMapping(value = "example",method = RequestMethod.GET)
    public String simpleGetExample() {
        return "I can do it";
    }
//传参
    @RequestMapping("path/vary/{things}")
    public String pathVary(@PathVariable Integer things){
        return "I heard of "+things+" really?";
    }

//    传多个参数
    @RequestMapping("query/param")
    public String queryParamExample(String username,Integer id){
        return "Get User "+username+": "+id+".";
    }
}
