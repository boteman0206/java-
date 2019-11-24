package com.example.demo.JDBC常用操作;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.sql.*;


/**
 * DriverManager： 用于注册驱动
 * Connection： 表示与数据库库创建连接
 * Statement: 操作数据库sql语的对象
 * ResultSet： 结果集或者一张虚拟的表
 */
public class 建立sqlq链接测试 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//       1：  注册驱动 不建议用第一种方式 第一种方式注册了两种方式 源码中可以看出
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver"); // 建议用这种方式

//        String url = "jdbc:mysql://127.0.0.1:3306/renren_fast?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String url="jdbc:mysql://localhost:3306/renren_fast?&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "1234";
//      2：  创建连接
        Connection conn = DriverManager.getConnection(url, user, password);
//      3：  得到statement对象
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from sys_menu");
//        statement.execute(sql);  通用的
//        statement.executeUpdate(sql);

        System.out.println(resultSet);
        // TODO: 2019/11/24
        // resultSet.next() // 光标向下移
//        resultSet.previous() 光标项前移
//        resultSet.afterLast(); 光标移动带末尾 末尾后面是没有数据的
//        resultSet.beforeFirst(); 光标移动到第一行 最前面一行是没有数据的
        while (resultSet.next()){
//           todo 通过类型获取
//            System.out.println(resultSet.getString("name"));
//            通过列索引获取
//            System.out.println(resultSet.getObject(1));
            System.out.println(resultSet.getObject("name"));

        }



//      todo  需要自己关闭连接
        resultSet.close();
        statement.close();
        conn.close();

    }
}
