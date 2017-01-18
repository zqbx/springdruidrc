package com.zqbx.controller;

import com.zqbx.service.CityService;
import com.zqbx.util.ResponseDto;
import com.zqbx.util.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "getcity", method = { RequestMethod.POST,RequestMethod.GET }, produces = "application/json")
    @ResponseBody
    public ResponseDto printWelcome(@RequestBody String json){
        ResponseDto dto = new ResponseDto();
        System.out.println("json:"+json);
        dto.setCode(ReturnCode.ACTIVE_SUCCESS.code());
        dto.setAttach("成功请求");
        return dto;
    }

}
