package com.example.demo.Service.Impl;
import com.example.demo.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Override
   @Async//开辟了单独的线程在执行
    public String addMemberAndEmial() {
        log.info("service第一行");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("service第二行");
        return "member";
    }
}
