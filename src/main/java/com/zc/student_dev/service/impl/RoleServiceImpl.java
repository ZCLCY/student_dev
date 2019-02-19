package com.zc.student_dev.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zc.student_dev.entity.Role;
import com.zc.student_dev.mapper.RoleMapper;
import com.zc.student_dev.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> queryById(Long id) {
        return roleMapper.queryById(id);
    }
}
