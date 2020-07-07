// package com.han.example.service.aop;
//
// import org.aspectj.lang.annotation.After;
// import org.aspectj.lang.annotation.AfterReturning;
// import org.aspectj.lang.annotation.AfterThrowing;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.stereotype.Component;
//
// /**
//  * @Description @ASpectJ注解驱动的切面
//  * @Date 2020/7/6 11:04
//  * @Author hanyf
//  */
// @Component //这个组件一定得加入到容器才行
// @Aspect
// public class HelloAspect {
//     @Pointcut("execution(* com.han.example.service.aop.*.*(..)) ")
//     public void point() {
//     }
//     @Before("point()")
//     public void before() {
//         System.out.println("this is from HelloAspect#before...");
//     }
//     @After("point()")
//     public void after() {
//         System.out.println("this is from HelloAspect#after...");
//     }
//     @AfterReturning("point()")
//     public void afterReturning() {
//         System.out.println("this is from HelloAspect#afterReturning...");
//     }
//     @AfterThrowing("point()")
//     public void afterThrowing() {
//         System.out.println("this is from HelloAspect#afterThrowing...");
//     }
//     // 此处需要注意：若写了@Around方法，那么最后只会执行@Around和@AfterReturning 其它的都不会执行
//     //@Around("point()")
//     //public void around() {
//     //    System.out.println("this is from HelloAspect#around...");
//     //}
// }
