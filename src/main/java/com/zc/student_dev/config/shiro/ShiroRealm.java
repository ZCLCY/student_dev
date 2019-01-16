package com.zc.student_dev.config.shiro;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zc.student_dev.entity.User;
import com.zc.student_dev.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userDTO = (User) principals.getPrimaryPrincipal();   //获取用户登录信息
        /*Set<String> roles = userService.selectRoleCodeByUserId(userDTO.getId());
        authorizationInfo.setRoles(roles);
        Set<String> permissions = userService.selectPermissionCodeByUserId(userDTO.getId());
        authorizationInfo.setStringPermissions(permissions);*/
        return authorizationInfo;
    }

    /**
     * 去执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        Wrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("username",username);
        User user = iUserService.selectOne(wrapper);
        user.setId(user.getId());
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
