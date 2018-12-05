package com.zc.student_dev.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank
    @ApiModelProperty(name = "用户名",example = "yyy",position = 1)
    private String username;

    @NotBlank
    @ApiModelProperty(name = "密码",example = "123456",position = 2)
    private String password;

    @ApiModelProperty(name = "自动登录,勾选则7天免登陆",example = "false",position = 3)
    public boolean rememberMe;
}
