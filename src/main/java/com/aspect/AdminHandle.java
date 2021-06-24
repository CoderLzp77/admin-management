package com.aspect;

import com.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
@Aspect
@Slf4j
public class AdminHandle {
    @Autowired
    private R r;
    @Pointcut("@annotation(com.annotation.Admin)")
    public void Admin(){}

    @Around("Admin()")
    public Object Around(ProceedingJoinPoint joinPoint){
        Method method = getMethod(joinPoint);

        Object[] args = joinPoint.getArgs();
        log.info(args.toString());
        return r.error();
    }

    public Method getMethod(ProceedingJoinPoint joinPoint){
       MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod();
    }
}
