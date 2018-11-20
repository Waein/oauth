package com.waein.safety.constant;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: ErrorCode, v 0.1 错误编码
 * @CreateDate 2018/11/19
 * @CreateTime 09:09
 * @GitHub https://github.com/Waein
 * ===================================
 */
public class ErrorCode {

    /**
     * 服务器内部错误
     */
    public static final int SERVER_INTERNAL_ERROR = 1000;
    /**
     * 参数丢失错误
     */
    public static final int PARAMETER_MISSING_ERROR = 1001;
    /**
     * 参数非法错误
     */
    public static final int PARAMETER_ILLEGAL_ERROR = 1002;
    /**
     * 资源未找到错误
     */
    public static final int RESOURCE_NOT_FOUND_ERROR = 1003;

    /**
     * Prevent instantiation
     */
    private ErrorCode() {
    }
}
