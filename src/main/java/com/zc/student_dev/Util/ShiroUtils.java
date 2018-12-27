package com.zc.student_dev.Util;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

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

}
