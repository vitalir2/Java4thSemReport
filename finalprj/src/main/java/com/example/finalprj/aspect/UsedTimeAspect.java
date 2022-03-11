package com.example.finalprj.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class UsedTimeAspect {

    private long beginningTime;

    @Before("usedTimeOnServices()")
    public void saveBeginningTime(JoinPoint joinPoint) {
        beginningTime = System.currentTimeMillis();
    }

    @After("usedTimeOnServices()")
    public void logUsedTimeMethod(JoinPoint joinPoint) {
        long finalTime = System.currentTimeMillis();
        long duration = finalTime - beginningTime;
        log.info("Spent " + duration + " millis on method " + joinPoint.toString());
    }

    @Pointcut("within(com.example.finalprj.service.*)")
    public void usedTimeOnServices() {

    }
}
