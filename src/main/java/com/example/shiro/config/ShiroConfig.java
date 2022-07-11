package com.example.shiro.config;

import com.example.shiro.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ginger
 */
public class ShiroConfig {


    /**
     * 安全管理器
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro内置过滤器
        /**
         * anon:无需认证就能访问
         * authc:认证了才能访问
         * user：必须拥有 记住我 功能才能访问
         * role：拥有某个角色才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("user/add","role");
        return bean;
    }


    /**
     * 管理subject
     * @param userRealm
     * @return securityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return  securityManager;
    }
    /**
     * 创建realm对象
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
