package com.example.springbootcourse.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassNameAddConfiguration
 * @Description TODO
 * @Author86182
 * @Date2021/11/1516:23
 * @Version 1.0
 **/
//注解配置
@Configuration
public class AddConfiguration {
//    Bean是有默认初始化函数的类
    @Bean
    public WebMvcConfigurer corsConfigurer(){
//        临时声明一个类
//        return一个new类型
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*");
            }
        };
    }
}
