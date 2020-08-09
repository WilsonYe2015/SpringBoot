package com.example.demo.sims.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTool {
    private final static Logger logger = LoggerFactory.getLogger(AspectTool.class);

    @Pointcut("execution(public * com.example.demo.sims.controller..*(..))")
    private void Controllerlog()
    {
    }

    @Pointcut("execution(public * com.example.demo.sims.service..*(..))")
    private void Servicelog()
    {
    }

    @Before("Controllerlog()")
    private void doControllerBefore(JoinPoint joinPoint){

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

    }

    @After("Controllerlog()")
    private void doControllerAfter()
    {
        logger.info("Controller After..");
    }


    @AfterReturning(returning = "object", pointcut = "Controllerlog()")
    public void doControllerAfterReturning(Object object) {
        logger.info("Controller response={}", object.toString());
    }


    @Before("Servicelog()")
    private void doServiceBefore(JoinPoint joinPoint){
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("Servicelog()")
    private void doServiceAfter()
    {
        logger.info("Service After..");
    }

    @AfterReturning(returning = "object", pointcut = "Servicelog()")
    public void doServiceAfterReturning(Object object) {
        logger.info("Service response={}", object.toString());
    }
}
