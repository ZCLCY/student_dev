package com.zc.student_dev.config.shiro;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zc.student_dev.entity.User;
import com.zc.student_dev.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 去执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        String username = (String)token.getPrincipal();
        Wrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("username",username);
        User user = iUserService.selectOne(wrapper);
        if(Objects.isNull(user) || Objects.isNull(user.getPassword()) || Objects.isNull(user.getSalt())){
            return null;
        }
        // 第一个参数：认证的实体信息User
        // 第二个参数：从数据库中获取的密码
        // 第三个参数：盐值
        // 第四个参数：当前realm对象的name,调用父类的getName()方法即可
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(user.getSalt()),this.getName());
        return authenticationInfo;
    }


}
