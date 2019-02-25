package com.zc.student_dev.Util;

import java.util.regex.Pattern;

/**
 * @Description 常用工具类
 **/
public class Utils {
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    public static final String REGEX_LIKE_MOBILE = "^(\\+?86)?1[3-9][0-9]{9}$";

    public static boolean checkIsMobile(String mobile){
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    public static boolean checkLikeMobile(String mobile) {
        return mobile != null && Pattern.matches(REGEX_LIKE_MOBILE, mobile);
    }

    /***
     * @Description 去除mobile86开头数字
     * @Author YeLuo
     * @Param [mobile]
     * @Explain []
     * @return java.lang.String
     **/
    public static String turnTo11Mobile(String mobile){
        if (mobile.startsWith("+86") || mobile.startsWith("86")){
            return mobile.substring(mobile.indexOf("86")+2);
        }
        return mobile;
    }

    public static void main(String[] args) {
        System.out.println(Utils.checkLikeMobile("+8617853260236"));
    }
}
