package com.example.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author ginger
 */
public class UserRealm extends AuthorizingRealm {
    /**
     * 授权
     * @param principalCollection
     * @return null
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权！");
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return null
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

//        // 获取当前用户
//        Subject subject = SecurityUtils.getSubject();
//        // 封装用户登录数据
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        return null;

    }
}
