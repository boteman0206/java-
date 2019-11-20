package com.example.demo.java学习.反射;

public class ReflectTest {
    private String name;
    private int age;
    public String color = "red";
    public ReflectTest(){

    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "ReflectTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ReflectTest(String name) {
        this.name = name;
    }

    public ReflectTest(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void test(){
        System.out.println("test =====");
    }
    private void siyou(){
        System.out.println("siyou方法");
    }

    public void say(String data){
        System.out.println("say =====" + data);
    }
    public static void test1(){
        System.out.println("静态方法 test1");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
