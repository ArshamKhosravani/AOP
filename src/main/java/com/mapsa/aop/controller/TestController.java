package com.mapsa.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/{name}")
    public String test(@PathVariable("name") String name){
//        System.out.println("name: " + name);
        String result = "hello " + name;
   // ...


//        System.out.println("result: " + result);
        return result;
    }

    @GetMapping("/exp")
    public String testExp() throws Exception {
        throw new Exception();
    }

}
