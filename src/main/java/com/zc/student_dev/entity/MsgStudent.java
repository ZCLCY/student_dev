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
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MsgStudent extends ModelDomain {

    private static final long serialVersionUID = 1L;

    private String name;

    private Boolean sex;

    private String address;

}
