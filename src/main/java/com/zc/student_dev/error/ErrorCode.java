package com.zc.student_dev.error;



public enum ErrorCode {

    SERVER_OK(200, "请求成功"),
    TEST_CALL(200, "测试话术任务"),
    HTTP_EX(601, "HTTP异常"),
    /**
     * 服务端异常
     */
    DATA_CURDERR(1007, "数据CURD操作失败"),
    NOT_LOGIN(1008,"请先登录"),
    LOGIN_SECCUSS(3101,"登录成功"),
    ALREADY_LOGGED(1009,"你已经登陆了"),
    USER_NOT_EXIST(1100,"用户名不存在"),
    PASSWORD_ERROR(1101,"密码错误"),
    LOGOUT_SUCCESS(1102,"退出成功"),
    ;

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    ErrorCode(int code){
    	this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ErrorCode{");
        sb.append("code=").append(code);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}