package com.example.demo.Shiro;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
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
        log.info("调用权限验证");
        return null;
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
        String savedRequest =  SecurityUtils.getSubject().getSession().getHost();
        System.out.println("用户"+userName+"认证ShiroRealm");
        System.out.println("用户IP地址"+savedRequest+"-----------------------");
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
}
