package com.zc.student_dev.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zc.student_dev.entity.MsgStudent;
import com.zc.student_dev.mapper.MsgStudentMapper;
import com.zc.student_dev.service.IMsgStudentService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
@Service
public class MsgStudentServiceImpl extends ServiceImpl<MsgStudentMapper, MsgStudent> implements IMsgStudentService {

    @Autowired
    private MsgStudentMapper msgStudentMapper;
}
