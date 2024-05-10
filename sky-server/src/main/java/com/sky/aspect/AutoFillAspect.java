package com.sky.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 自定义切面，实现公共字段自动填充处理逻辑
 * (切面所在的类叫切面类,注解 @Aspect)
 * (切面 = 切入点表达式 + 通知)
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 切入点
     * (**抽取**)
     * (Spring提供了 @PointCut 注解，该注解的作用是将公共的切入点表达式抽取出来，需要用到时引用该切入点表达式即可。)
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut(){}

    /**
     * 前置通知，在通知中进行公共字段的赋值
     * (在Spring中用JoinPoint抽象了连接点，用它可以获得方法执行时的相关信息，如目标类名、方法名、方法参数等。)
     *
     * (对于@Around通知，获取连接点信息只能使用ProceedingJoinPoint类型)
     *
     * (对于其他四种通知，获取连接点信息只能使用JoinPoint，它是ProceedingJoinPoint的父类型)
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint){
        /////////////////////重要////////////////////////////////////
        //可先进行调试，是否能进入该方法 提前在mapper方法添加AutoFill注解
        log.info("开始进行公共字段自动填充...");

    }
}