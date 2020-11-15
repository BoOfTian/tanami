package com.example.learnspring.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect //表示这是一个切面
@Component// 并且将这个切面注入到Spring容器中
@Slf4j
public class SpringAspect {

    // 1.切点表达式：详细表达式可参考：https://www.cnblogs.com/itsoku123/p/10744244.html
    // https://blog.csdn.net/jinnianshilongnian/article/details/84156354?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight

    // 2.@Around,@Before,Method,@After,@AfterThrowing执行顺序：注意，如果在Around中不调用joinPoint.proceed()，则@Before注解的方法不会调用，但是@After还是会调用。
    // https://www.cnblogs.com/muxi0407/p/11983874.html

    // 3.@Around,@Before,@After,@AfterThrowing,@AfterReturning注解修饰等方法参是有区别的
    // 目前所知：除@Around方法入参为ProceedingJoinPoint，返回值类型为Object；其他4种通知入参为JoinPoint，返回值类型为void。
    // 参考 ：https://blog.csdn.net/u010502101/article/details/78823056

    @Pointcut("execution(* com.example.learnspring.controller..*.*(..))")
    //拦截包com.example.learnspring.controller及其子包下定义到方法
    public void thePointcut() {
        // 定义一个公用切入点
    }

    @Around("thePointcut()")//环绕增强使用公用切点thePointcut()
    public Object excuteTime(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        Object result = null;
        try {
            // @Before // 前置通知
//            log.info("前置通知调用..");
            result = pjp.proceed();
            //@AfterRetruning // 返回通知
//            log.info("返回通知调用...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //@AfterThrowing // 异常通知
//            log.info("异常通知调用...");
        }

        //@After // 后置通知
//        log.info("返回通知调用...");
        log.info("拦截到方法：{}.{},耗时：{}{}",pjp.getTarget().getClass(),pjp.getSignature().getName(),System.currentTimeMillis()-startTime,"毫秒");
        // self4j日志框架占位符：https://blog.csdn.net/Dongguabai/article/details/83719754
        return result;
    }

    @Before("execution(* com.example.learnspring.controller..*.*(..))")
    public void theCallMethod(JoinPoint jp){
        log.info("调用方法:{}.{}",jp.getTarget().getClass(),jp.getSignature().getName());
    }
}
