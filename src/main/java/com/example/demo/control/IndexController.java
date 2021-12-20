package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassNameIndexController
 * @Description TODO
 * @Author86182
 * @Date2021/12/320:49
 * @Version 1.0
 **/

//在templates目录下的所有页面，需要controller来跳转
//    模板引擎
@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
