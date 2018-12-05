package com.zc.student_dev.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class ShiroConfiguration {
    @Value("${shiro.config.login.url}")
    public String loginUrl;
    /**
     *创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 关联DefaultWebSecurityManager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /**
         * shiro内置过滤器，可以实现权限相关的拦截
         * 常用过滤器
         *    anno：无需认证(登录)可以访问
         *    authc：必须认证才可以访问
         *    user：如果使用rememberMe的功能可以直接访问
         *    perms：该资源必须得到资源权限才能访问
         *    role：该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterHashMap = new HashMap<>();
        filterHashMap.put("/student_dev/user/list","authc");
        //跳转到登陆的页面
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterHashMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(shiroRealm);


        return defaultWebSecurityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "shiroRealm")
    public ShiroRealm getRealm(){
        return new ShiroRealm();
    }



}
