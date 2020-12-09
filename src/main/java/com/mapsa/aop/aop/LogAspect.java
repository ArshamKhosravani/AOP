package com.mapsa.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Aspect
@Component
public class LogAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.mapsa.aop.controller.*.*(..))")
    public void allMethodLoge() {
    }

    @Before("allMethodLoge()")
    public void beforeCall(JoinPoint joinPoint){
        //
    }

    @Around("allMethodLoge()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        LOGGER.info(proceedingJoinPoint.getSignature().getName(),
                proceedingJoinPoint.getTarget().getClass());
        Object result = proceedingJoinPoint.proceed();
        if (result instanceof Collection) {
            LOGGER.info(result.toString());
        } else {
            LOGGER.info(result.toString());
        }

        return result;
    }

    @AfterThrowing(value = "allMethodLoge()", throwing = "ex")
    public void expAsp(Exception ex) {
        LOGGER.error("server exp");
        ex.printStackTrace();
    }
}
