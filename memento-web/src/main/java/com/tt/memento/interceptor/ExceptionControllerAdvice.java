package com.tt.memento.interceptor;

import com.tt.memento.common.ServerResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * controller异常处理
 * date: 2017/12/27
 * author: wt
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    public ServerResponse bindExceptionHandler(BindException e) {
        return ServerResponse.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public ServerResponse exceptionHandler(Exception e) {
        return ServerResponse.error(e.getCause().getLocalizedMessage());
    }
}
