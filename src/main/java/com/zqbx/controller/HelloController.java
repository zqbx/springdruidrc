package com.zqbx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zqbx.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller()
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "getcity", method = { RequestMethod.POST,RequestMethod.GET }, produces = "application/json")
    public String printWelcome(@RequestBody String json){
        System.out.println("json:"+json);
//        JSONObject.parse(json);
        return null;
    }
}
