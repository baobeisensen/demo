package com.example.demo.Controller;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/back")
@Slf4j
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * @Description 登录成功后跳转界面
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User userSearch = userService.query(user.getName(),user.getPwd());
        model.addAttribute("user", userSearch);
        return "back/index";
    }

    /**
     * @Description 攔截所有請求到登陸界面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        //model.addAttribute("error" , "账号或密码错误");
        return "/back/login";
    }

    @RequestMapping("/main")
    public String page(){
        return "/back/main";
    }

    /**
     * 无权限
     * @return
     */
    @RequestMapping("/404")
    public String Err(){
        return "/back/404";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("/changepwd")
    public String changepwd(){
        return "/back/changepwd";
    }


    /**
     * 个人信息
     * @param model
     * @return
     */
    @RequestMapping("/personInfo")
    public String personInfo(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user",user);
        return "/back/personInfo";
    }

    /**
     * 登录请求方法
     * @param username
     * @param password
     * @param rememberMe
     * @param model
     * @return
     */
    @PostMapping("/login")
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
            return "/back/login";
        } catch (IncorrectCredentialsException e) {
            log.error("密码错误"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error","账号或密码错误");
            return "/back/login";
        } catch (LockedAccountException e) {
            log.error("账号已锁定"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error","账号已锁定");
            return "/back/login";
        } catch (AuthenticationException e) {
            log.error("没有相应权限"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("error","账号权限不足");
            return "/back/login";
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
