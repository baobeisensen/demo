package com.example.demo.Controller;

import com.example.demo.Service.Impl.MemberServiceImpl;
import com.example.demo.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @Value("${envirment}")
    private String envirment;

    @RequestMapping("addMemberAndEmail")
    @ResponseBody
    public String addMemberAndEmail(){
        //String member ="member";
        log.info("Controller第一行");
        memberService.addMemberAndEmial();
        log.info("Controller第二行");
        return "member";
    }
    @RequestMapping("getEnvirment")
    @ResponseBody
    public String getEnvirment(){
        return envirment;
    }
    @RequestMapping("test")
    @ResponseBody
    public String test(){
        String a = "a1";
        return a;
    }

}
