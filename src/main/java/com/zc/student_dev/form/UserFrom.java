package com.zc.student_dev.form;


import com.zc.student_dev.result.BasePageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserFrom extends BasePageQuery {

    @ApiModelProperty(value = "用户名")
    private String username;
}
