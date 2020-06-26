package com.example.demo;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.java8.User;
import com.example.demo.java8.UserTest;
import com.example.demo.java8.函数式接口;
import com.example.demo.java8.接口的默认方法;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
public class Tmyest {

    @Test
    public void test1() {
        接口的默认方法 d1 = new 接口的默认方法() {
            @Override
            public double calculate(int a) {
                return a * 100;
            }
        };

        double calculate = d1.calculate(10);
        System.out.println("calculate = " + calculate);
        double sqrt = d1.sqrt(100);
        System.out.println("squrt = " + sqrt);
        接口的默认方法.demo1(12);
    }


    @Test
    public void test2() {
        函数式接口<String, Integer> t1 = (num -> {
            return Integer.valueOf(num);
        });
        Integer convert = t1.convert("2324");
        System.out.println(convert.getClass());
    }

    @Test
    public void test3() {
        Predicate<String> predicate2 = s -> s.length() > 3;
        Predicate<String> predicate1 = s -> s.startsWith("j");
        System.out.println(predicate2.test("hello"));
        //   取反
        System.out.println(predicate2.negate().test("hello"));
        // and 使用 两者都满足
        Predicate<String> andCondition = predicate2.and(predicate1);
        System.out.println(andCondition.test("java"));
        // or的使用
        Predicate<String> or = predicate1.or(predicate2);
        System.out.println(or.test("ja"));

        Predicate<Object> objectPredicate = Objects::nonNull;
        Predicate<Object> objectPredicate1 = Objects::isNull;
        System.out.println(objectPredicate.test(null));
        System.out.println(objectPredicate1.test(null));
        String name = "jack";

    }

    @Test
    public void test4() {
        String name1 = null;
        String name2 = new String();
        String name3 = "";
        String name4 = "    ";

        System.out.println(StringUtils.isEmpty(name1));
        System.out.println(StringUtils.isEmpty(name2));
        System.out.println(StringUtils.isEmpty(name3));
        System.out.println(StringUtils.isEmpty(name4));
        System.out.println("-------------");
        System.out.println(StringUtils.isBlank(name1));
        System.out.println(StringUtils.isBlank(name2));
        System.out.println(StringUtils.isBlank(name3));
        System.out.println(StringUtils.isBlank(name4));

//        System.out.println(name1.isEmpty());
        System.out.println(name2.isEmpty());
        System.out.println(name3.isEmpty());
    }

    @Test
    public void test5() {
        Function<Integer, Integer> function = num -> num + 1;
        Function<Integer, Integer> function1 = num -> num * 2;
        Function<Integer, Integer> function2 = num -> num * 100;
        System.out.println(function.apply(1));      // out:11
        System.out.println("compose = " + function1.compose(function).compose(function2).apply(1));   // out:22
        System.out.println("andThen = " + function1.andThen(function).apply(1)); // out 12

        BiFunction<Integer, Integer, Integer> bF = (i1, i2) -> Integer.parseInt(i1 + i2 + "");
        System.out.println(bF.apply(1, 2));

        System.out.println("==============");

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.name);
        greeter.accept(new Person("Luke", "Skywalker"));

        Consumer<String> t1 = (p) -> System.out.println("Hello, " + StringUtils.upperCase(String.valueOf(p.charAt(0))));
        t1.accept("hello");

        String name = "jack";
        char c = name.charAt(0);

        Consumer<String> t11 = p -> System.out.println(p.toLowerCase());
        Consumer<String> t12 = p -> {
            String s = StringUtils.upperCase(p);
            System.out.println(s);
        };

        t11.accept("   helllo  ");

    }

    @Test
    public void test6() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
        List list = new ArrayList();
        list.add("lis1");
        stringList.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });

        Stream<String> a = stringList.stream().filter((p) -> p.startsWith("a"));
        a.forEach(p -> System.out.println(p));


        Optional<String> reduce = stringList.stream().reduce((r1, r2) -> r1 + "##" + r2);
        System.out.println(reduce);
        String s = reduce.get();
        System.out.println(s);

        String optional = Optional.ofNullable(null).map(p -> p.toString()).orElse("is null");
        System.out.println(optional);

    }

    @Test
    public void test7() {
        Map map = new HashMap();
        map.put("key", null);
        System.out.println(map);
        Object not_found = map.getOrDefault("key", "not found");
        System.out.println(Objects.isNull(not_found));
        map.put("name", "buke");
        Object o = map.putIfAbsent("key", "jack");
        System.out.println(o);
        Object o1 = map.putIfAbsent("name", "kkkkk");
        System.out.println(o1);
        System.out.println(map);

    }

    @Test
    public void test8() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println();
    }


    @Test
    public void test9() {
        Date date = new Date();
        System.out.println(date);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDate of = LocalDate.of(2012, 3, 21);
        System.out.println("of = " + of);
        LocalDate parse = LocalDate.parse("2012-04-12");
        System.out.println("标准时间 = " + parse);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        LocalDate parse1 = LocalDate.parse("2012-7-17", formatter);
        System.out.println("cuowu = " + parse1);

        int dayOfYear = now.getDayOfYear();
        System.out.println("dayofyear = " + dayOfYear);
        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("with = " + with);

    }

    @Test
    public void test11() {
        User user1 = new User();
//        user1.setId(1);
        user1.setName("jack");
        user1.setAge(18);

        User user2 = new User();
//        user2.setId(2);
        user2.setName("jack");
        user2.setAge(18);

        System.out.println(user1.equals(user2));


    }

    @Test
    public void test12() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> collect = list.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        List<String> collect1 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]
        System.out.println(collect1); //[A, B, C, D]

        List<Integer> widgets = Arrays.asList(1, 2, 3, 4);
        int sum = widgets.stream()
                .filter(n -> Integer.valueOf(n.toString()) > 2)
                .mapToInt(n -> Integer.valueOf(n.toString()))
                .sum();
        System.out.println("sum = " + sum);
        IntStream.range(1, 10).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        List<String> collect12 = Arrays.asList("a", "b", "c", "d", "c", "b");
        Set<String> collect2 = collect12.stream().map(String::toUpperCase).collect(Collectors.toSet());
        System.out.println(collect2);


    }

    @Test
    public void test13() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);

        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(collect);
    }


    @Test
    public void test14(){
        String name = "hello";
        String address = "jack";
        User user = new User();
        user.setName("");
        user.setAge(12);
        Optional<String> reduce = Stream.of(name, address).reduce(String::concat);
        String s = reduce.get();
        System.out.println(s);

        Optional<String> optionalS = Optional.ofNullable(user).map(u -> u.getName());
        System.out.println(optionalS.isPresent());
        
        System.out.println("ppppp" + optionalS.get());
    }


    @Test
    public void test21(){
        User user = new User("name12", 12, "13");
        User user2 = new User("name19", 19, "13");
        User user3 = new User("name12", 21, "13");
        User user4 = new User("name13", 5, "13");
        List<User> list = Arrays.asList(user, user2, user3, user4);
//        Map<Boolean, List<User>> collect = list.stream().collect(
////                Collectors.groupingBy(p -> p.getAge() < 18 && p.getName().equals("name112"))
////        );
        Map<String, List<User>> collect = list.stream().collect(
                Collectors.groupingBy(u -> u.getName() + "_" + u.getAddr())
        );

        for (Map.Entry<String, List<User>> booleanListEntry : collect.entrySet()) {
            System.out.println(booleanListEntry.getKey() + "===" + booleanListEntry.getValue());
            booleanListEntry.getValue().forEach(user22 -> {
                String name = user22.getName().toUpperCase();
                System.out.println(name);
            });
        }

    }

    @Test
    public void streamTest(){
        Stream<UserTest> userStream = Stream.of(new UserTest(0, "张三", 18), new UserTest(1, "张四", 19), new UserTest(2, "张五", 19), new UserTest(3, "老张", 50));
        Map<Integer, List<UserTest>> ageMap = userStream.collect(Collectors.toMap(UserTest::getAge,
                Collections::singletonList, (a, b) -> {
            List<UserTest> resultList = new ArrayList<UserTest>(a);
            resultList.addAll(b);
            return resultList;
        }));
        System.out.println(ageMap);
        for (Map.Entry<Integer, List<UserTest>> integerUserTestEntry : ageMap.entrySet()) {
            System.out.println(integerUserTestEntry.getKey() + "=====" + integerUserTestEntry.getValue()
            + "-----" + integerUserTestEntry.getValue().size()
            );
        }
    }

    @Test
    public void test(){
        Stream<UserTest> userStream = Stream.of(new UserTest(1, "张三", 18), new UserTest(1, "张四", 19), new UserTest(2, "张五", 19), new UserTest(3, "老张", 50));
        Map<Integer, String> map = userStream.collect(
                Collectors.toMap(
                        UserTest::getId,
                        UserTest::getName,
                        (old, newValue) -> old)
        );
        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println(integerStringEntry.getKey() + "====" + integerStringEntry.getValue() );
        }
    }

    @Test
    public void testr1(){
        List list = Arrays.asList(1, 34, 55, 12);
        List lists = Collections.singletonList(12);
        System.out.println(lists);
    }

    @Test
    public  void collectTest(){
        // 由于基本类型都是不可变类型,所以这里用数组当做容器
        final Integer[] integers = Lists.newArrayList(1, 2, 3, 4, 5)
                .stream()
                .collect(() -> new Integer[]{0}, (a, x) -> a[0] += x, (a1, a2) -> a1[0] += a2[0]);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    @Test
    void GitTest(){
        System.out.println("git ceshi");
    }
}

