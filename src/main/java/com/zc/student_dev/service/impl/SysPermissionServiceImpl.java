package com.zc.student_dev.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zc.student_dev.entity.SysPermission;
import com.zc.student_dev.mapper.SysPermissionMapper;
import com.zc.student_dev.mapper.UserMapper;
import com.zc.student_dev.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Set<String> queryById(Long roleId) {
        return sysPermissionMapper.queryById(roleId);
    }
}
