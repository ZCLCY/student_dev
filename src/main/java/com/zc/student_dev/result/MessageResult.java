package com.zc.student_dev.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zc.student_dev.error.ErrorCode;
import lombok.Data;

import java.io.Serializable;


@Data
public class MessageResult<T> implements Serializable {
	
	private static final long serialVersionUID = 1409391871452693846L;
	
	
	// 响应业务状态
	private Integer code;
	
	// 响应消息
	private String message;
	
	// 响应中的数据
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;
	
	//响应中的状态状态码
	private boolean success;
	
	private Long count;
	
	public MessageResult() {
		
	}
	
	public MessageResult(Integer code, String message, T data, boolean success, Long count) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.success = success;
		this.count = count;
	}
	
	public MessageResult(Integer code, String message, T data, boolean success) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	public  MessageResult<T> ok() {
		return new MessageResult<T>(ErrorCode.SERVER_OK.getCode(), ErrorCode.SERVER_OK.getMsg(), null, true);
	}
	
	public  MessageResult<T> ok(T data) {
		return new MessageResult<T>(ErrorCode.SERVER_OK.getCode(), ErrorCode.SERVER_OK.getMsg(), data, true);
	}

	public  MessageResult<T> ok(ErrorCode errorCode) {
		return new MessageResult<T>(errorCode.getCode(), errorCode.getMsg(), null, true);
	}
	
	public  MessageResult<T> ok(T data, String message) {
		return new MessageResult<T>(ErrorCode.SERVER_OK.getCode(), message, data, true);
	}
	public  MessageResult<T> ok(T data, Long count) {
		return new MessageResult<T>(ErrorCode.SERVER_OK.getCode(), ErrorCode.SERVER_OK.getMsg(), data, true, count);
	}
	
	public  MessageResult<T> ok(T data, Long count, String message) {
		return new MessageResult<T>(ErrorCode.SERVER_OK.getCode(), message, data, true, count);
	}
	
	public  MessageResult<T> failure(Integer code, String msg) {
		return new MessageResult<T>(code, msg, null, false);
	}
	
	public  MessageResult<T> failure(ErrorCode errorCode) {
		return new MessageResult<T>(errorCode.getCode(), errorCode.getMsg(), null, false);
	}

}
