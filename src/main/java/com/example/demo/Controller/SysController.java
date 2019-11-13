package com.example.demo.Controller;

import com.example.demo.Service.SystemService;
import com.example.demo.Utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system")
public class SysController {
    @Resource
    private SystemService systemService;

    /**
     * 获取服务器信息
     * @return
     */
    @GetMapping("/getSystem")
    public Result getSystem(){
        return systemService.getSystem();
    }

    /**
     * 获取数据库版本
     * @return
     */
    @GetMapping("/getDatabaseInfo")
    public Result getDatabaseInfo(){
        return systemService.getDatabaseInfo();
    }

    /**
     * 查询解锁密码
     * @return
     */
    @GetMapping("/getUplockPassword")
    public Result getUplockPassword(){
        return systemService.getUplockPassword();
    }
}
