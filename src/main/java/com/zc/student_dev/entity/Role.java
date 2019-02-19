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
public class Role extends ModelDomain {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     *  1-系统级 2-公司级 3-部门级 4-普通级
     */
    private Integer roleType;
    private String roleCode;

}
