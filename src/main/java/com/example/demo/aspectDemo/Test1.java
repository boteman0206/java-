package com.example.demo.aspectDemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Aspect
@Configuration
public class Test1{

    @Before("execution(* com.example.demo.aspectDemo.*.*(..))")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("method:  " + methodName + "  begins");
    }

    @After("execution(* com.example.demo.aspectDemo.*.*(..))")
    public void After(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("method:  " + methodName + "  ends");
    }

    @AfterReturning(value="execution(* com.example.demo.aspectDemo.*.*(..))",returning="result")
    public void AfterReturning(JoinPoint joinPoint,Object result ){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("method:  "+methodName+"  return result:"+result);
    }
    /*** 该方法定义了Exception最高异常级别，也可以定义具体异常
    * @param joinPoint
     * @param exception
 */
    @AfterThrowing(value="execution(* com.example.demo.aspectDemo.*.*(..))",throwing="exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("method:  "+methodName+"occurs exception:"+exception);
    } /**
 * 环绕通知需带着ProceedingJoinPoint参数
 * ProceedingJoinPoint参数决定是否执行目标方法
 * 必须有返回值
 * @param pjp
 * @return
 */
    @Around(value = "execution(* com.example.demo.aspectDemo.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        String methodName = pjp.getSignature().getName();
        Object result = null;
        try {
            // before
            System.out.println("method:  " + methodName + "  begins");
            // AfterReturning执行目标方法
            result = pjp.proceed();
            System.out.println("method:  " + methodName + "  return result:" + result);
        } catch (Throwable e) {
            // AfterThrowing
            System.out.println("method:  " + methodName + "occurs exception:" + e);
        } // After
        System.out.println("method:  " + methodName + "  ends");
        return result;
    }
}

