package com.example.demo.Config;

import com.example.demo.Shiro.ShiroRealm;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig{
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/back/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/back/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/back/404");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //注意过滤器配置顺序 不能颠倒
        // 配置不会被拦截的链接 顺序判断
        //anon 匿名拦截器，即不需要登录即可访问；一般用于静态资源过滤；示例/static/**=anon
        //authc：必须认证才可以访问
        //user:如果使用rememberMe的功能才可以直接访问
        //perms:该资源必须得到资源权限才可以访问
        //role：该资源必须得到角色权限才可以访问
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/manage/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/other/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/test/**", "anon");
        filterChainDefinitionMap.put("/checkcenter/**", "anon");
        filterChainDefinitionMap.put("/websocket/**", "anon");
        filterChainDefinitionMap.put("/socketTest.html", "anon");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/about", "anon");
        filterChainDefinitionMap.put("/job", "anon");
        filterChainDefinitionMap.put("/product", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        filterChainDefinitionMap.put("/logout", "logout");


       // filterChainDefinitionMap.put("/", "anon");
        //基于表单的拦截器；如/**=authc，如果没有登录会跳到相应的登录页面登录
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
