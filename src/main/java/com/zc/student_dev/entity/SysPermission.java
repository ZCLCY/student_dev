package com.zc.student_dev.entity;

import com.zc.student_dev.domain.ModelDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysPermission extends ModelDomain {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限编码
     */
    private String code;
    /**
     * 访问地址
     */
    private String url;

}
