package com.zc.student_dev.controller;


import com.zc.student_dev.service.IMsgStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
@RestController
@RequestMapping("/student_dev/msg-student")
public class MsgStudentController {

    @Autowired
    private IMsgStudentService iMsgStudentService;

}
