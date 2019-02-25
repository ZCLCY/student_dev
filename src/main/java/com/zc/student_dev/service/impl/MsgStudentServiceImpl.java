package com.zc.student_dev.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zc.student_dev.entity.MsgStudent;
import com.zc.student_dev.mapper.MsgStudentMapper;
import com.zc.student_dev.service.IMsgStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class MsgStudentServiceImpl extends ServiceImpl<MsgStudentMapper, MsgStudent> implements IMsgStudentService {

    @Autowired
    private MsgStudentMapper msgStudentMapper;
}
