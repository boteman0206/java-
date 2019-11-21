package com.example.demo.java学习.jav的枚举;

public enum  Season {
    /**
     * 定义枚举的关键字 是enum
     * 所有的枚举类都是Enum的子类
     * todo 枚举类的第一行必须是枚举项, 最后一个枚举项的分号可以省略
     * 枚举可以有构造器 但是必须是private
     * 枚举也可以有抽象方法 但是枚举项必须实现此方法
     *
     */
    Spring, Summer, Autumn, Winter;
    Season(){
        System.out.println("空参数的方法调用");
    }

}


class test{
    public static void main(String[] args) {
        Season winter = Season.Winter;
        Season  spring = Season.Spring;
        // TODO: 枚举的常用方法
//        1: 枚举的所引
        int ordinal = spring.ordinal();
        int ordinal1 = winter.ordinal();
        System.out.println(ordinal);
        System.out.println(ordinal1);
//        2： 比较 也是索引的比较
        System.out.println(spring.compareTo(winter));
//        3: 枚举的名称
        String name = spring.name();
        System.out.println(name);
//        4: tostring方法也是枚举的名称
        System.out.println(spring.toString());
//        5: valueof 通过字节码来获取对象
        System.out.println(Season.valueOf(Season.class, "Spring"));

//        6: 枚举的遍历
        System.out.println("+===========");
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }

    }

}