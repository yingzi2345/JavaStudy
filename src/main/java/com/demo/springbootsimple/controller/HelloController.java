package com.demo.springbootsimple.controller;

import com.demo.springbootsimple.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    /*@GetMapping("/user2")
   public Map<String, Object> getUser() {
       Map<String, Object> map = new HashMap<>();
       map.put("name", "cyl");
       map.put("age", 22);
       return map;
   }*/

    //———————————————————————————三种传参方式—————————————————————
   /* @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "") String name) {
        System.out.println(name);
        return "hello springboot!";
    }*/

    /*@GetMapping("/hell/{name}")//路径映射要对！
    public String hell(@PathVariable String name) {
        System.out.println(name);
        return "Hello SpringBoot!";
    }*/

    @PostMapping("/user")//get只能get，这里要用post！
    public String hell(@RequestBody User user) {
        System.out.println("name:"+user.getName());
        System.out.println("age:"+user.getAge());
        return "Hello SpringBoot!";
    }





}



