package com.example.demo.fanxinTest;

public class demo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClaz = Class.forName("com.example.demo.fanxinTest.Student");
        pet(aClaz);


        Class<Student> studentClass = Student.class;
        pet(studentClass);
    }


    public static void pet(Class<?> cla) throws IllegalAccessException, InstantiationException {
        Object o = cla.newInstance();

        System.out.println(o.getClass());
        ((Student) o).get();

    }
}
