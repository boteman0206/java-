package com.example.demo.fanxinTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class demo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClaz = Class.forName("com.example.demo.fanxinTest.Student");
        pet(aClaz);


        Class<Student> studentClass = Student.class;
        pet(studentClass);

        System.out.println("===========test===============");
        test(aClaz);
    }


    public static void pet(Class<?> cla) throws IllegalAccessException, InstantiationException {
        Object o = cla.newInstance();

        System.out.println(o.getClass());
        ((Student) o).get();


    }


    public static void test(Class cla) throws IllegalAccessException, InstantiationException {
        Object o = cla.newInstance();

        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            System.out.println("method " + method);
        }

        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod " + declaredMethod);
        }


        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredFields " + declaredField);
        }

    }
}
