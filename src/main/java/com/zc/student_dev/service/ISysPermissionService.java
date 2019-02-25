package com.zc.student_dev.service;

import com.baomidou.mybatisplus.service.IService;
import com.zc.student_dev.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 */
public interface ISysPermissionService extends IService<SysPermission> {
    Set<String> queryById(@Param("roleId") Long roleId);
}
