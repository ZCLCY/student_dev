package com.zc.student_dev.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserUpdateForm {
    @ApiModelProperty(value = "用户名")
    private String username;
}
