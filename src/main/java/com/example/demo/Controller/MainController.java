package com.example.demo.Controller;
import	java.util.HashMap;
import java.util.Map;

import com.example.demo.Entity.Visit;
import com.example.demo.Service.VisitService;
import com.example.demo.Utils.SysUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Resource
    private VisitService visitService;
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        Visit v = new Visit();
        String ip = SysUtil.getClientIp(request);
        v.setIp(ip);
        visitService.insert(v);
        return "index";
    }
    @RequestMapping("about")
    public String about() {
        return "about";
    }
    @RequestMapping("product")
    public String product() {
        return "product";
    }

    @RequestMapping("job")
    public String job() {
        return "job";
    }

}
