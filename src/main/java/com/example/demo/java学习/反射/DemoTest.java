package com.example.demo.java学习.反射;

import com.example.demo.Person;

public class DemoTest {
    /**
     * 获取字节码的三种方式：
     *  1： obj的 getClass
     *  2： 静态属性的class
     *  3： class类中的静态方法 forName（ 参数传递累的全部路径）
     *
     */
    public static void main(String[] args) throws ClassNotFoundException {

        // TODO: 2019/11/20  方式一
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass.hashCode());

        // TODO: 2019/11/20 方拾二
        Class<Person> personClass = Person.class;
        System.out.println(personClass.hashCode());

        // TODO: 2019/11/20  方式三  传递全路径的名字
        Class<?> aClass1 = Class.forName("com.example.demo.Person");
        System.out.println(aClass1.hashCode());


//       todo 内存中只有一份class字节码文件 可以通过hashcode验证

    }
}
