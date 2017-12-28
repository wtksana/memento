package com.tt.memento.interceptor;

import com.tt.memento.common.ServerResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * date: 2017/12/27
 * author: wt
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ServerResponse bindExceptionHandler(BindException e){
        return ServerResponse.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
