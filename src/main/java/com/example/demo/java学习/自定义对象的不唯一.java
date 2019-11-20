package com.example.demo.java学习;

import java.util.*;

public class 自定义对象的不唯一 {
    public static void main(String[] args) {
        List<OnlyOne> list = new ArrayList<>();  // arrayList如果要使用必须用contains方发来激活equals方法
        OnlyOne onlyOne1 = new OnlyOne("JACK", "T1");
        OnlyOne onlyOne2 = new OnlyOne("JACK1", "T2");
        OnlyOne onlyOne3 = new OnlyOne("JACK1", "T1");
        OnlyOne onlyOne4 = new OnlyOne("JACK", "T1");
        OnlyOne onlyOne5 = new OnlyOne("ttt", "T1");

        list.add(onlyOne1);
        list.add(onlyOne2);
        list.add(onlyOne3);
        list.add(onlyOne4);
        list.add(onlyOne5);
        List<OnlyOne> list1 = new ArrayList<>();
        for (OnlyOne onlyOne : list) {
            System.out.println(onlyOne);
            if(!list1.contains(onlyOne)){
                list1.add(onlyOne);
                System.out.println("不重复的 " + onlyOne);
            }
        }
        System.out.println("去重之后的 长度  = " + list1.size());

        System.out.println("======list=============");


        Set<OnlyOne> set = new HashSet<>();
        set.add(onlyOne1);
        set.add(onlyOne2);
        set.add(onlyOne3);
        set.add(onlyOne4);
        set.add(onlyOne1);
        set.add(onlyOne5);
        Iterator<OnlyOne> iterator = set.iterator();
        while (iterator.hasNext()){
            OnlyOne next = iterator.next();
            System.out.println(next);
        }

        System.out.println("=======treeSet==========");

        Set<OnlyOne> set1 = new TreeSet<>();
        set1.add(onlyOne1);
        set1.add(onlyOne2);
        set1.add(onlyOne3);
        set1.add(onlyOne4);
        set1.add(onlyOne5);
        set1.add(onlyOne2);
        set1.add(onlyOne3);
        Iterator<OnlyOne> iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            OnlyOne next = iterator1.next();
            System.out.println(next);
        }
    }
}





class OnlyOne implements Comparable<OnlyOne> {
    private String keyName;
    private String keyWord;
    OnlyOne(){

    }

    OnlyOne(String name, String word){
        this.keyName = name;
        this.keyWord = word;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals----------");
        if (this == o) return true;
        if (!(o instanceof OnlyOne)) return false;
        OnlyOne onlyOne = (OnlyOne) o;
        return Objects.equals(this.keyName, onlyOne.keyName) ||
                Objects.equals(this.keyWord, onlyOne.keyWord);
//        if (Objects.equals(this.keyName, onlyOne.keyName)){
//            return true;
//        }
//        if (Objects.equals(this.keyWord, onlyOne.keyWord)){
//            return true;
//        }
//        return false;
    }

//    @Override
//    public int hashCode() {
//        System.out.println("hash-------------");
//        return Objects.hash(keyName);
//    }

    @Override
    public String toString() {
        return "OnlyOne{" +
                "keyName='" + keyName + '\'' +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }

    @Override
    public int compareTo(OnlyOne onlyOne) {
        int i = this.keyWord.compareTo(onlyOne.keyWord);
        if (i != 0){
            i = this.keyName.compareTo(onlyOne.keyName);
        }
        System.out.println(" i =========== " + i);
        return i;
    }


}
