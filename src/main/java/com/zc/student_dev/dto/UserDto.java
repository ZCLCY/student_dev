package com.zc.student_dev.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String number;
    private String username;
    private String password;
    private String salt;
}
