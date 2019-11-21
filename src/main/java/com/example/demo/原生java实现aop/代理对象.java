package com.example.demo.原生java实现aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 代理对象 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        HelloWorldImpl helloWorld = new HelloWorldImpl();
        // todo jdk 实现的代理只能够代理接口

//        注意点： 这里必须要实现 ISayHelloWorld 接口对象 进行方法的调用
        ISayHelloWorld o = (ISayHelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), (Class<?>[]) helloWorld.getClass().getGenericInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                方法会在这里进行拦截
                System.out.println("权限审核");
                System.out.println(method);
                Object invoke = method.invoke(helloWorld, args);// TODO: 这里才是真正进行代码的运行
                System.out.println("日志记录");
                return invoke;
            }
        });

        System.out.println(o.getClass());
        o.say(); // todo 这里调用方法会被 invoke方法进行拦截
    }
}
