package com.hsl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.lang.annotation.Documented;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Aspect
@Component
public class SayHello {
    @Pointcut(value = "@annotation(com.hsl.annotation.MyAspect)")
    public void log(){};

    @Around("log()")
    public Object before(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        System.out.println("方法开始了");
        explainAnno(point);
        return  result;
    }
//    @After("log()")
//    public void after(ProceedingJoinPoint point){
//        System.out.println("方法结素了");
//        explainAnno(point);
//    }

    private void explainAnno(ProceedingJoinPoint point){
        Signature signature = point.getSignature();
        MethodSignature methodSignature = null;
        if (signature instanceof MethodSignature){
            methodSignature = (MethodSignature) signature;
        }else {
            throw new IllegalArgumentException("只能用于方法");
        }
        String name = methodSignature.getName();
        String[] parameterNames = methodSignature.getParameterNames();
        for (String parameterName : parameterNames) {
            System.out.println(parameterName);
        }
        System.out.println(name);
    }

}
