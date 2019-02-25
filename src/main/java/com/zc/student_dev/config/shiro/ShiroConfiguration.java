package com.zc.student_dev.config.shiro;

import com.zc.student_dev.Util.ShiroUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfiguration {
    @Value("${shiro.config.login.url}")
    public String loginUrl;

    @Value("#{${shiro.config.filter.map}}")
    public Map<String, String> map = new LinkedHashMap<>();

    @Value("${shiro.config.authenticationCacheName}")
    private String authenticationCacheName;

    @Value("${shiro.config.rememberMe.name}")
    public String rememberMeName;
    @Value("${shiro.config.rememberMe.maxAge}")
    public Integer maxAge;

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 关联DefaultWebSecurityManager
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        //把不需要登录便可以访问的接口放进去
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //跳转到登陆的页面
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        /**
         * shiro内置过滤器，可以实现权限相关的拦截
         * 常用过滤器
         *    anno：无需认证(登录)可以访问
         *    authc：必须认证才可以访问
         *    user：如果使用rememberMe的功能可以直接访问
         *    perms：该资源必须得到资源权限才能访问
         *    role：该资源必须得到角色权限才可以访问
         */
        Map<String, Filter> filterHashMap = new HashMap<>();
        filterHashMap.put("authc", shiroFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filterHashMap);
        return shiroFilterFactoryBean;
     }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public SecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(shiroRealm());

        // 自定义session管理 使用redis
        /* defaultWebSecurityManager.setSessionManager(sessionManager());*/
        // 自定义缓存实现 使用redis
        /*defaultWebSecurityManager.setCacheManager(cacheManager());*/
        // 记住登录
         defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        return defaultWebSecurityManager;
    }

   /*@Bean
    public ShiroSessionManager sessionManager() {
        ShiroSessionManager sessionManager = new ShiroSessionManager();
        sessionManager.setGlobalSessionTimeout(  1000);
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }*/

    /*@Bean
    public SessionDAO sessionDAO() {
        RedisSessionDAO sessionDAO = new RedisSessionDAO();
        sessionDAO.setRedisManager(redisManager());
        sessionDAO.setExpire(313);
        sessionDAO.setKeyPrefix("");
        return sessionDAO;
    }*/

    @Bean
    public HashedCredentialsMatcher matcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        matcher.setHashAlgorithmName(ShiroUtils.HASH_ALGORITHM);
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        matcher.setHashIterations(ShiroUtils.HASH_ITERATIONS);
        return matcher;
    }

    /**
     * 创建Realm
     */
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(matcher());
        shiroRealm.setAuthorizationCacheName(authenticationCacheName);
        return shiroRealm;
    }

    @Bean
    public ShiroFormAuthenticationFilter shiroFormAuthenticationFilter() {
        return new ShiroFormAuthenticationFilter();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor advisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(getDefaultWebSecurityManager());
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        /** 设置是否直接代理目标类，而不只是代理特定的接口 */
        creator.setProxyTargetClass(true);
        return creator;
    }
    //cookie()rememberMeManager()是记住我
    @Bean
    public Cookie cookie(){
        SimpleCookie cookie = new SimpleCookie();
        cookie.setName(rememberMeName);
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    @Bean
    public RememberMeManager rememberMeManager(){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(cookie());
        return rememberMeManager;
    }
}
