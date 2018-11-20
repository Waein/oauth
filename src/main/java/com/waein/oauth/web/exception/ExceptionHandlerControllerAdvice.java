package com.waein.oauth.web.exception;

import com.waein.oauth.constant.ErrorCode;
import com.waein.oauth.model.dto.Error;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: ExceptionHandlerControllerAdvice, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 14:30
 * @GitHub https://github.com/Waein
 * ===================================
 */
@CommonsLog //lombok注解自动生成日志
@ControllerAdvice
class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(HttpServletRequest request, ResourceNotFoundException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error()
                        .setCode(ErrorCode.RESOURCE_NOT_FOUND_ERROR)
                        .setMessage(e.getMessage()));
    }

    @ExceptionHandler(ParameterIllegalException.class)
    public ResponseEntity<?> parameterIllegalExceptionHandler(HttpServletRequest request, ParameterIllegalException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Error()
                        .setCode(ErrorCode.PARAMETER_ILLEGAL_ERROR)
                        .setMessage("An invalid value was specified for one of the query parameters in the request URL."));
    }

    @ExceptionHandler(ServerInternalErrorException.class)
    public ResponseEntity<?> serverInternalErrorExceptionHandler(HttpServletRequest request, ServerInternalErrorException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Error()
                        .setCode(ErrorCode.RESOURCE_NOT_FOUND_ERROR)
                        .setMessage("The server encountered an internal error. Please retry the request."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(HttpServletRequest request, Exception e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Error()
                        .setCode(ErrorCode.SERVER_INTERNAL_ERROR)
                        .setMessage("The server met an unexpected error. Please contact administrators."));
    }

    /********************************** HELPER METHOD **********************************/
    private void logError(HttpServletRequest request, Exception e) {
        log.error("[URI: " + request.getRequestURI() + "]"
                + "[error: " + e.getMessage() + "]");
    }

}
