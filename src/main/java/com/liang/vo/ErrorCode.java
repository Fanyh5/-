package com.liang.vo;

/**
 * 错误代码
 *
 * @author vip
 * @date 2022/03/05 16:48
 */
public enum ErrorCode {
    NO_ERROR(0,"成功"),
    DB_ERROR(1, "数据库错误"),
    DATA_EXIST(4, "数据已存在"),
    LOGIN_EXCEPTION(5, "登录出错"),
    SYSTEM_ERROR(6, "系统错误"),
    LOGIC_OBEY(8, "逻辑提示"),
    FEIGIN_ERROR(7, "内部调用错误"),
    DATA_NONE(9, "数据不存在"),
    FILE_UPLOAD(12, "文件上传错误"),
    FILE_DOWNLOAD(13, "文件下载错误"),
    FILE_ERROR(14, "文件错误"),
    FILE_MISS_CHUNKS(16, "文件部分模块上传错误"),
    WORKFLOW_ERROR(15, "工作流错误"),
    PARAMS_ERROR(10001,"参数有误"),
    ACCOUNT_PWD_NOT_EXIST(10002,"用户名或密码不存在"),
    USER_DOES_NOT_EXIST(10003,"用户不存在"),
    WRONG_PASSWORD(10004,"密码错误"),
    INCORRECT_VERIFICATION_CODE(10005,"验证码不正确"),
    USER_ALREADY_EXISTS(10006,"用户已存在"),
    REGISTRATION_FAILED(10007,"注册失败"),
    VERIFICATION_CODE_ERROR(10008,"验证码错误"),
    DESTINATION_MAILBOX_DOES_NOT_EXIST(10009,"目标邮箱不存在"),
    TEXT_EMAIL_SENDING_EXCEPTION(10010,"文本邮件发送异常"),
    ACCESS_TOKEN_INVALID(1005,"access_token无效"),
    REFRESH_TOKEN_INVALID(1006, "refresh_token无效"),
    NO_PERMISSION(70001,"无访问权限"),
    SESSION_TIME_OUT(90001,"会话超时"),
    INSUFFICIENT_PERMISSIONS(1003,"该用户权限不足以访问该资源接口"),
    UNAUTHORIZED(1004,"访问此资源需要完全的身份验证"),
    NO_LOGIN(90002,"未登录"),;


    private int code;
    private String msg;

    ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
