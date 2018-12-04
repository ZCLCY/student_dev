package com.zc.student_dev.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAddFrom {
    @ApiModelProperty(value = "模板名称")
    private String username;
    @ApiModelProperty(value = "模板类型")
    private String password;

}
