package com.example.demo.java学习.数据库的链接;

public class DemoTest {
    public static void main(String[] args) {


        // TODO: 2019/11/24 null  + 数字 为null 可以用if函数或者ifnull
//      todo  union all 不去重 union去重将两个表全连接  两张表的字段要一样

//        笛卡尔积 两个表的乘积 a表里面的一行记录回合b表里面的所有记录进行相连
        // TODO: 2019/11/24 年加一
//        select date_add("2018-12-12", interval 1 year);
//        select now() 获取当前时间
        // TODO: 2019/11/24 当前时间转换成字符串
//        select date(cast((select now()) as char));
//        select current_time();
//        select current_date();

//        select truncate(5.27, 1);  todo 直接截取 不会四舍五入 只能截取数字或者字符格式的数字 如果是纯字母自动变为 0.x
//        时间差值
//        select datediff("2018-12-14", "2018-12-10");


        // TODO: 2019/11/24 字符串的常用方法
//        1： ucase() 大写
//        2： lcase() 小写
//        todo left和trancate的区别一个针对字符串的一个是针对数字的
//        3： left(str, length)  select left("hello", 3); 从字符串的左边开始截取多长
//        4: length() 长度
//        5： replace() 替换   select replace("hello", "l", "m");
//        6：select concat("hello", "world") 字符串的拼接
//        7：  select trim("      hello "); 取出空格  ltrim() rtrim()    select length( ltrim("      hello "));
//        8： select strcmp("ac", "ab");  todo 0 相同 1 左边的字符串大 -1右边的字符大
//        9 select substring("hello", 2, 3);
//        10 select substr("hello", 2, 3); 和上面的一样 2后面保留3个字符  后面不写默认保留2后面全部


//       todo 数学函数
//        select format(5.228, 2) 保留小数点后面两位 自动四舍五入
//        select truncate(5.27, 1);  todo 直接截取 不会四舍五入 只能截取数字或者字符格式的数字 如果是纯字母自动变为 0.x
//        select ceiling(5.3) 向上取整数
//        select floor(5.3) 向下取整
//        select rand(reed) 返回0到1之间的随机小数 ，包括0 不包括1， 两个相同的RAND()返回的数值不同,reed一样两个相同的RAND(X)，只要里面的X一样，返回数就相同。
    }
}
