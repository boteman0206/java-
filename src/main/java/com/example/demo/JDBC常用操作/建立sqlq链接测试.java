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
//       1：  注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

//        String url = "jdbc:mysql://127.0.0.1:3306/renren_fast?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String url="jdbc:mysql://localhost:3306/renren_fast?&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "1234";
//      2：  创建连接
        Connection conn = DriverManager.getConnection(url, user, password);
//      3：  得到statement对象
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from sys_menu");
        System.out.println(resultSet);
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }


    }
}
