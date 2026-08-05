package com.demo.springbootsimple.handler;

import com.demo.springbootsimple.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//异常处理的对象
public class GlobalExceptionHandler {



    @ExceptionHandler(RuntimeException.class)
    public Result handlerException(RuntimeException e){
        return Result.error(e.getMessage());
    }
}
