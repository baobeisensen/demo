package com.example.demo.Controller;
import com.example.demo.Entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/back")
public class LoginController {

    /**
     * @Description 登录成功后跳转界面
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "back/index";
    }

    /**
     * @Description 攔截所有請求到登陸界面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        System.out.println("login");
        return "/back/login";
    }

    @RequestMapping("main")
    public String page(){
        return "/back/main";
    }

    @RequestMapping("/404")
    public String Err(){
        return "/back/404";
    }
    @RequestMapping("/personInfo")
    public String personInfo(){
        return "/back/personInfo";
    }

}
