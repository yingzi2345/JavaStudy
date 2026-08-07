package com.demo.springbootsimple.handler;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotPermissionException;
import com.demo.springbootsimple.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.PublicKey;

@RestControllerAdvice//异常处理的对象
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public Result handlerException(RuntimeException e){return Result.error(e.getMessage());}

    @ExceptionHandler(NotPermissionException.class)
        public Result handlerNotPermissionException(NotPermissionException e){
            SaHolder.getResponse().setStatus(403);
            return Result.error(e.getMessage());
        }
    }

