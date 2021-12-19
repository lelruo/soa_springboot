package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {

    @RequestMapping("/map")
    @ResponseBody
    public double[][] sendLocation(){
        double[][] data={
                {30.312903,120.382029},
                {30.215855,120.024568},
                {30.18015,120.174968},
                {30.324994,120.164399},
                {30.24884,120.305074}
        };
        return data;
    }
}
