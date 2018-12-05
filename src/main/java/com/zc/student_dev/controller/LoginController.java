package com.zc.student_dev.controller;

import com.zc.student_dev.error.ErrorCode;
import com.zc.student_dev.form.LoginForm;
import com.zc.student_dev.result.MessageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 这是一个秘密
 */

@Api(tags = "登录与退出")
@RestController
public class LoginController {

    @ApiIgnore
    @RequestMapping("/notLogin")
    public MessageResult<Object> notLogin() {
        return new MessageResult<>().failure(ErrorCode.NOT_LOGIN);
    }


    @ApiOperation("登录")
    @PostMapping("/login")
    public MessageResult<Object> login(@RequestBody LoginForm form) {
        MessageResult<Object> messageResult = new MessageResult<>();
        /**
         * 使用shiro编写认证操作
         */
        // 获取subject
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            // 封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername().trim(), form.getPassword().trim(), form.isRememberMe());
            // 执行登录方法
            subject.login(token);
        } else {
            messageResult = messageResult.ok(ErrorCode.ALREADY_LOGGED);
            return messageResult;
        }
        return null;
    }

    @ApiOperation("退出登录")
    @RequiresAuthentication
    @PostMapping("/logout")
    public MessageResult<Object> logout() {
        MessageResult<Object> messageResult = new MessageResult<>();
        SecurityUtils.getSubject().logout();
        return messageResult.ok(ErrorCode.LOGOUT_SUCCESS);
    }


}
