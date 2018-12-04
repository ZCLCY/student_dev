package com.zc.student_dev.domain;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
public class ModelDomain implements Serializable {
    private static final long serialVersionUID = 78345405523985L;

    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

    @TableField(fill = FieldFill.INSERT)
    protected Integer crtTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Integer updTime;
}
