package org.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect//定义切面，表示进行aop编程
@Component
public class TestAOP {

    //定义切点：进行方法拦截
    @Pointcut("execution(* org.example.demo.controller.*.*(..))")
    public void loginPointcut(){

    }

    //通知：前置通知，传入   切点方法名()
    @Before("loginPointcut()")
    public void beforeRequest(){
        System.out.println("@Before");
    }

    //通知：后置通知
    @After("loginPointcut()")
    public void afterRequest(){
        System.out.println("@After");
    }

    @AfterReturning("loginPointcut()")
    public void afterRequestReturn(){
        System.out.println("@AfterReturning");
    }

    @AfterThrowing("loginPointcut()")
    public void afterRequestThrow(){
        System.out.println("@AfterThrowing");
    }

    @Around("loginPointcut()")
    public Object aroundRequest(ProceedingJoinPoint joinPoint){
        Object obj = null;
        try{
            //方法执行前可以加入前置逻辑
            System.out.println("@Around前执行");
            obj = joinPoint.proceed();//目标方法执行
            System.out.println("@Around后执行");
        }catch (Throwable e){
//            e.printStackTrace();
            System.err.println("@Around捕获异常");
        }
        return obj;
    }
}
