package com.hihusky;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    @Before("execution(* com.hihusky.MyClass.perform())")
    public void beforeDoSomething() {
        System.out.println("Before advice: Intercepting doSomething()");
    }

    @After("execution(* com.hihusky.MyClass.perform())")
    public void afterDoSomething() {
        System.out.println("After advice: Intercepting doSomething()");
    }
}