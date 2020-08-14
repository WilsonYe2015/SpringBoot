package com.example.demo.sims.common.aspect;

import com.example.demo.sims.common.exception.BizException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    /**
     * @description  前置通知
     */
    @Before("Controllerlog()")
    private void doControllerBefore(JoinPoint joinPoint){

        logger.info("Controller before..");
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

    }

    /**
     * @description  后置通知
     */
    @After("Controllerlog()")
    private void doControllerAfter()
    {
        logger.info("Controller After..");
    }

    /**
     * @description  使用环绕通知
     */
    @Around("Controllerlog()")
    public Object doControllerAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        //try{
            logger.info("Around Controller Before..");
            result = pjp.proceed();
            logger.info("Around Controller After..");
        //}
       // catch(Throwable e){
        //    logger.info("异常通知：Controller Around,"+e.getMessage());
      // }
        return result;
    }


    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning(returning = "object", pointcut = "Controllerlog()")
    public void doControllerAfterReturning(Object object) {
        logger.info("Controller After Returning response={}", object.toString());
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing(throwing="ex",pointcut = "Controllerlog()")
    public void doControllerAfterThrowing(Throwable ex) throws Throwable {
        logger.info("异常通知：Controller:"+ ex.getMessage());
    }

    /**
     * @description  前置通知
     */
    @Before("Servicelog()")
    private void doServiceBefore(JoinPoint joinPoint){
        logger.info("Service Before..");
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    /**
     * @description  后置通知
     */
    @After("Servicelog()")
    private void doServiceAfter()
    {
        logger.info("Service After..");
    }

    /**
     * @description  使用环绕通知
     */
   @Around("Servicelog()")
    public Object doServiceAround(ProceedingJoinPoint pjp) throws Throwable {
       Object result = null;
      // try{
            logger.info("Around Service Before..");
            result = pjp.proceed();
            logger.info("Around Service After..");
       // }
      //  catch(Throwable e){
       //     logger.info("异常通知：Service Around,"+e.getMessage());
      //  }
       return  result;
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning(returning = "object", pointcut = "Servicelog()")
    public void doServiceAfterReturning(Object object) {
        logger.info("Service After Returning response={}", object.toString());
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing(throwing="ex",pointcut ="Servicelog()")
    public void doServiceAfterThrowing(Throwable ex) throws Throwable {
        logger.info("异常通知：Service :"+ ex.getMessage());
    }
}
