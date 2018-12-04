package com.zc.student_dev.aop;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import static com.zc.student_dev.config.AppConstants.J_CRT_TIME;
import static com.zc.student_dev.config.AppConstants.J_UPD_TIME;


/**
 * 数据自动填充
 */
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        int now = (int) (System.currentTimeMillis()/1000);
        Object crtTime = getFieldValByName(J_CRT_TIME, metaObject);//如果存在，则跳过设置
        Object updTime = getFieldValByName(J_UPD_TIME, metaObject);//
        if (crtTime == null) {
            setFieldValByName(J_CRT_TIME, now, metaObject);//mybatis-plus版本2.0.9+
        }
        if (updTime == null) {
            setFieldValByName(J_UPD_TIME, now, metaObject);//mybatis-plus版本2.0.9+
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        int now = (int) (System.currentTimeMillis()/1000);
        setFieldValByName(J_UPD_TIME, now, metaObject);
    }
}
