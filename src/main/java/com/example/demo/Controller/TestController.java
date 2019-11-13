package com.example.demo.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@EnableAutoConfiguration
public class TestController {
    @RequestMapping("/test")
    public Integer test(Integer property){
        return property/0;
    }
    @RequestMapping("/list")
    @ResponseBody
    public List test(@RequestParam("ls") List<Integer> ls){
        return ls;
    }
    @RequestMapping("/socketTest")
    public String test(){
        return "socketTest";
    }


}
