package com.zc.student_dev.entity;

import com.zc.student_dev.domain.ModelDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends ModelDomain {

    private static final long serialVersionUID = 1L;

    private String number;
    private String username;
    private String password;
    private String salt;
    private Long roleId;
}
