package com.example.demo.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@EnableAutoConfiguration
public class TestController {
    @RequestMapping("/test")
    public String test(String signature,String timestamp,String nonce,String echostr){
        System.out.println("-------------------------------------------------");
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        System.out.println("-------------------------------------------------");
        return echostr;
    }
   /* @RequestMapping("/list")
    @ResponseBody
    public List test(@RequestParam("ls") List<Integer> ls){
        return ls;
    }
    @RequestMapping("/socketTest")
    public String test(){
        return "socketTest";
    }*/


}
