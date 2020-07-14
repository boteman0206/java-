package com.example.demo.设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler  implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("写代码之前准备");
        Object result = method.invoke(object, args);
        System.out.println("写代码之后收钱");

        System.out.println("code方法的返回值： " + result);
        return result;
    }
}
