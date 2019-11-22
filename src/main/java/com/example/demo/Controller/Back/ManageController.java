package com.example.demo.Controller.Back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManageController {
    /**
     * 跳转角色
     * @return
     */
    @GetMapping("/back/admin/role")
    public String role(){
        return "/back/admin/role";
    }
}
