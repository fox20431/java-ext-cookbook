package com.hihusky;

public class Main {

    public static void main(String[] args) throws Exception {
        MyClass demoObject = new MyClass();

        // 创建代理对象
        MyClass proxy = new MyClass();

        // 调用被拦截的方法
        proxy.perform();
    }
}