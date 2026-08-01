package com.demo.springbootsimple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringBoot!";
    }
    @GetMapping("/user")
    public Map<String,Object> getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","cyl");
        map.put("age",22);
        return map;
    }

}



