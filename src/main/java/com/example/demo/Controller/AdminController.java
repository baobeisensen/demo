package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @RequestMapping("/login")
    public String login(String username, String password, Boolean rememberMe,Model model){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "redirect:/back/index";
        } catch (UnknownAccountException e) {
            log.error("账号错误"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error","账号或密码错误");
            return "/admin/login";
        } catch (IncorrectCredentialsException e) {
            log.error("密码错误"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error","账号或密码错误");
            return "/admin/login";
        } catch (LockedAccountException e) {
            log.error("账号已锁定"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error","账号已锁定");
            return "/admin/login";
        } catch (AuthenticationException e) {
            log.error("没有相应权限"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error","账号权限不足");
            return "/admin/login";
        }
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

}
