package com.zc.student_dev.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zc.student_dev.entity.User;
import com.zc.student_dev.error.ErrorCode;
import com.zc.student_dev.form.UserAddFrom;
import com.zc.student_dev.form.UserFrom;
import com.zc.student_dev.form.UserUpdateForm;
import com.zc.student_dev.result.MessageResult;
import com.zc.student_dev.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhangcai
 * @since 2018-12-03
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/student_dev/user")
public class UserController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/list")
    @ApiOperation(value = "查询用户", notes = "成功success，失败failure")
    public MessageResult<List<User>> selectAll(UserFrom query) {
        Page<User> page = new Page<>(query.getPage(), query.getLimit(), query.getSortName(), query.isAsc());
        Wrapper<User> wrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(query.getUsername())) {
            wrapper.eq("username", query.getUsername());
        }
        Page<User> userPage = iUserService.selectPage(page, wrapper);
        List<User> userList = userPage.getRecords();
        System.out.println(userList + "+" + userPage.getTotal());
        return new MessageResult<List<User>>().ok(userList, userPage.getTotal());
    }

    @PostMapping("/")
    @ApiOperation(value = "新增用户", notes = "成功success，失败failure")
    public MessageResult<String> insert(@RequestBody UserAddFrom form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        Boolean flag = iUserService.insert(user);
        return flag ? new MessageResult<String>().ok("success")
                : new MessageResult<String>().failure(ErrorCode.DATA_CURDERR);
    }


    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public MessageResult<Object> delete(@PathVariable Long id) {
        MessageResult<Object> messageResult = new MessageResult<>();
        User user = iUserService.selectById(id);
        if (user == null) {
            return new MessageResult<>().failure(ErrorCode.DATA_CURDERR);
        }
        iUserService.deleteById(id);
        return messageResult.ok("success");
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新用户", notes = "成功success，失败failure")
    public MessageResult<Object> updateSmsTemplate(@PathVariable Long id, @RequestBody UserUpdateForm form) {
        User user = iUserService.selectById(id);
        if (user == null ) {
            return new MessageResult<>().failure(ErrorCode.DATA_CURDERR);
        }
        user.setId(id);
        user.setUsername(form.getUsername());
        return new MessageResult<>().ok(iUserService.insertOrUpdate(user));
    }


    @GetMapping("/listSmsTemplate")
    @ApiOperation(value = "查询所有用户", notes = "成功success，失败failure")
    public MessageResult<List<User>> selectSmsTemplateListPage(UserFrom query) {
        redisTemplate.opsForValue().set("name","zclcy");
        System.out.println(redisTemplate.opsForValue().get("name"));
        Page<User> page = new Page<>(query.getPage(), query.getLimit(), query.getSortName(), query.isAsc());
        Wrapper<User> wrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(query.getUsername())) {
            wrapper.like("username", query.getUsername());
        }
        Page<User> pageSmsTemplate = iUserService.selectPage(page, wrapper);
        List<User> listSmsTemplate = pageSmsTemplate.getRecords();
        List<User> volist = listSmsTemplate.stream().map(smsTemplate -> {
            User vo  = new User();
            BeanUtils.copyProperties(smsTemplate,vo);
            return vo;
        }).collect(Collectors.toList());
        return new MessageResult<List<User>>().ok(volist, pageSmsTemplate.getTotal());
    }

}
