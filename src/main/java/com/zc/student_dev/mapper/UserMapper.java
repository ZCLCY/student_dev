package com.zc.student_dev.mapper;

import com.zc.student_dev.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
