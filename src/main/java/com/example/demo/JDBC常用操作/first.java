package com.example.demo.JDBC常用操作;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class first {
    public static void main(String[] args) {

        try {

            String url = "jdbc:mysql://127.0.0.1:3306/renren_fast?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            // 1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2、获取数据库连接
            Connection conn = DriverManager.getConnection(url, "root", "1234");

            // 3、获取数据库操作对象
            Statement statement = conn.createStatement();

            // 4、定义操作的 SQL 语句
            String sql = "select * from sys_user";

            // 5、执行数据库操作
            ResultSet resultSet = statement.executeQuery(sql);

            // 6、获取并操作结果集
            while (resultSet.next()) {
                // 解析结果集
                System.out.println(resultSet.getString("username"));

            }

        } catch (Exception e) {
            // 日志信息
        } finally {
            // 7、关闭资源
        }
    }


}
