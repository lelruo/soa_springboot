package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "地图接口")
@CrossOrigin
@RestController
public class Controller {

    @ApiOperation("查询列表（不分页）")
    @RequestMapping(value="/map",method = RequestMethod.GET)
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
