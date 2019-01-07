package com.zc.student_dev.Util;

import com.baomidou.mybatisplus.mapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @description: Shiro工具类
 * @author: Zhijie Yang
 * @create: 2018-10-25 10:42
 */
@SuppressWarnings("all")
@Slf4j
public class ShiroUtils {

    //随机数生成器
    private static RandomNumberGenerator random = new SecureRandomNumberGenerator();

    //指定散列算法为md5
    public final static String HASH_ALGORITHM = "MD5";
    //散列迭代次数
    public final static int HASH_ITERATIONS = 2;

    /**
     * 获取用户id
     * @return 用户id
     */
   /* public static Long getSessionUserId(){
        SysUser user = getSessionUser();
        if(user.getId() == null){
            return 0L;
        }
        return user.getId();
    }
*/
    /**
     * 获取用户
     * @return 用户对象
     */
   /* public static SysUser getSessionUser(){
        if (ThreadContext.getSecurityManager() == null || ThreadContext.getSubject() == null //过滤xxl-job，消息等中间件
                || ThreadContext.getSubject().getPrincipal() == null){  //过滤shiro放行
            return new SysUser();
        }
        Subject subject = SecurityUtils.getSubject();

        if(Objects.isNull(subject)||subject.getSession()==null) {
            return new SysUser();
        }
        Object principal = subject.getPrincipal();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(principal,userDTO);
        SysUser user = new SysUser();
        BeanUtils.copyProperties(userDTO,user);
        user.setDeptId(userDTO.getDepartmentId());
        return user;
    }*/

    /** 生成盐值 */
    public static String generateSalt(){
        return random.nextBytes().toHex();
    }

    /** 生成密码 */
    public static String generatePassword(String password,String salt){
        return new SimpleHash(HASH_ALGORITHM,password,ByteSource.Util.bytes(salt),HASH_ITERATIONS).toHex();
    }

    /** 生成密码 */
    public static String generatePassword(String password){
        return new SimpleHash(HASH_ALGORITHM,password).toHex();
    }

}
