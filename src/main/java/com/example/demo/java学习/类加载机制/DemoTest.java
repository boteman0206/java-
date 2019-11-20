package com.example.demo.java学习.类加载机制;

public class DemoTest {
    /**
     * 类加载的时机
     * 1： 创建类的实例对象 new Student()
     * 2: 访问类的静态变量， 或者为静态变量赋值
     * 3： 调用类的静态的方法
     * 4： 初始化某一个子类 也或将他的父类加载
     * 5： 直接使用java.exe的命令来运行某一个主类
     * 6： 使用反射的方式来强制创建某个类或者接口的实例对象的时候
     *
     */

    /**
     * 类加载器的概述：
     *     负责将.class文件加载到内存中，并为之生成对应的Class对象
     * 类加载器的分类：
     *     1： 根加载器 Bootstrap ClassLoader
     *         -- 负责加载 java的核心类  rt.jar
     *     2： 扩展类加载器  Extension ClassLoader
     *         -- 负责加载  jre扩展目录中的类
     *     3： 系统类加载器  System ClassLoader
     *          -- jvm 启动时候加载
     */

    public static void main(String[] args) {

    }



}
