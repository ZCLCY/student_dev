package com.zc.student_dev.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zc.student_dev.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    Set<String> queryById(@Param("roleId") Long roleId);
}
