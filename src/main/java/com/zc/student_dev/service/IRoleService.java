package com.zc.student_dev.service;

import com.baomidou.mybatisplus.service.IService;
import com.zc.student_dev.entity.Role;

import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
public interface IRoleService extends IService<Role> {

    Set<String> queryById(Long id);

}
