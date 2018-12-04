package com.zc.student_dev.config.shiro;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @program: ai_callcenter
 * @description: shiro自定义的realm，用于获取用户的认证和授权
 * @author:
 * @create: 2018-10-24 09:39
 **/
/*
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    */
/** 授权 *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User sysUser = new User();
        BeanUtils.copyProperties(principals.getPrimaryPrincipal(),sysUser);
        Long userid = sysUser.getId();
        User user = userService.selectById(userid);
        authorizationInfo.setRoles(user.getRoleSet().stream().map(e->e.getCode()).collect(Collectors.toSet()));
        authorizationInfo.setStringPermissions(user.getPermissionSet().stream().map(e->e.getCode()).collect(Collectors.toSet()));
        return authorizationInfo;
    }

    */
/** 认证 *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        User user = userService.selectUserByUsername(username);
        if(Objects.isNull(user) || Objects.isNull(user.getPassword()) || Objects.isNull(user.getSalt())){
            return null;
        }
        */
/* 状态 0禁用 1可用 2 账户被锁定 4 删除 *//*

        if(Arrays.asList(0,2,4).contains(user.getStatus())){
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(user.getSalt()),this.getName());
        return authenticationInfo;
    }
}
*/
