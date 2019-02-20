package com.zc.student_dev.service;

import com.baomidou.mybatisplus.service.IService;
import com.zc.student_dev.entity.SysPermission;
import com.zc.student_dev.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
public interface ISysPermissionService extends IService<SysPermission> {
    Set<String> queryById(@Param("roleId") Long roleId);
}
