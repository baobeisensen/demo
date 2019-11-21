package com.example.demo.Shiro;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Resource
    private UserDao userDao;
/**
     * 获取用户角色和权限
     * @param principalCollection
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前用户
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        //到数据库查询用户id对应的授权
        log.info("调用权限验证");
        return info;
    }

/**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName =(String) authenticationToken.getPrincipal();
        String password =new String((char[]) authenticationToken.getCredentials());
        //String savedRequest =  SecurityUtils.getSubject().getSession().getHost();
        User user = userDao.queryByUserNameAndPwd(userName,password);
        if (user==null){
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPwd())){
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,getName());
        return info;
    }
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException, TemplateException {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:templates/");
        freemarker.template.Configuration configuration = freeMarkerConfigurer.createConfiguration();
        configuration.setDefaultEncoding("UTF-8");
        //这里可以添加其他共享变量 比如sso登录地址
        configuration.setSharedVariable("shiro", new ShiroTags());
        freeMarkerConfigurer.setConfiguration(configuration);
        return freeMarkerConfigurer;
    }
}
