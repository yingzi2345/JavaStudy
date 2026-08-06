package com.demo.springbootsimple.aspect;

import com.demo.springbootsimple.common.Result;
import net.sf.jsqlparser.statement.select.Join;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Around("execution(* com.demo.springbootsimple.controller.*.*(..))")
    public Result around(ProceedingJoinPoint Joinpoint) {
        System.out.println("在方法执行之前");
        try {
            Result result = (Result) Joinpoint.proceed();
            System.out.println(result.toString());
            System.out.println("在方法执行之后");
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
