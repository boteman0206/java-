package com.example.demo.java学习.模板设计模式;

import com.example.demo.JieBatest.Person;
import com.example.demo.java架构.test;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.junit.Test;
import org.mortbay.util.StringMap;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class Mytest {

    @Test
    public void test1(){
        Stream.iterate(0, n -> n + 3)
                .limit(10).
                forEach(x -> System.out.print(x + " "));



    }

    @Test
    public void test2(){
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");


        Map<String, Long> collect = items.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
        System.out.println(collect);

    }

    @Test
    public void test3(){
        Person user1 = new Person("zhangsan", "78", "beijing");
        Person user2 = new Person("zhangsan", "20", "shanghai");
        Person user3 = new Person("lisi", "67", "beijing");
        List<Person> list = new ArrayList<Person>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Map<String, List<Person>> collect = list.stream().collect(
                Collectors.groupingBy(
                        Person::getName
                ));
        System.out.println(collect);
        // {lisi=[Person(name=lisi, age=67, addr=beijing)], zhangsan=[Person(name=zhangsan, age=78, addr=beijing), Person(name=zhangsan, age=20, addr=shanghai)]}
        Map<String, Map<String, List<Person>>> collectp
                = list.stream().collect(
                Collectors.groupingBy(
                        Person::getAddr, Collectors.groupingBy(Person::getName)
                )
        );
        System.out.println("00000000000 = " + collectp);

    }

    @Test
    public void test4(){
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
// 分组
        Map<String, List<String>> result1 = items.stream().collect(
                Collectors.groupingBy(
                        Function.identity()
                )
        );

        System.out.println(result1);
    }

    @Test
    public void test8(){
        TimeUnit hours = TimeUnit.HOURS;
        long convert = hours.convert(1, TimeUnit.DAYS);
        System.out.println(convert);

        System.out.println(TimeUnit.HOURS.toDays(2));


    }
}
