package com.zc.student_dev.exception;

import com.zc.student_dev.error.ErrorCode;
import com.zc.student_dev.result.MessageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 密码错误
	 */
	@ExceptionHandler(IncorrectCredentialsException.class)
	@ResponseBody
	public MessageResult incorrectCredentialsException(IncorrectCredentialsException e){
		log.warn("{} ------- {} -------- {}",e.getClass(),ErrorCode.PASSWORD_ERROR.getMsg(),e.getMessage());
		return new MessageResult().failure(ErrorCode.PASSWORD_ERROR);
	}

	/**
	 * 用户不存在
	 */
	@ExceptionHandler(UnknownAccountException.class)
	@ResponseBody
	public MessageResult unknownAccountException(UnknownAccountException e){
		log.warn("{} ------- {} -------- {}",e.getClass(),ErrorCode.USER_NOT_EXIST.getMsg(),e.getMessage());
		return new MessageResult().failure(ErrorCode.USER_NOT_EXIST);
	}
}
