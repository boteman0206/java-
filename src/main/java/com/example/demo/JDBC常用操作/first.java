package com.example.demo.JDBC常用操作;

import java.sql.*;

public class first {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


//            String url = "jdbc:mysql://127.0.0.1:3306/renren_fast?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        // TODO: 2019/11/24 上面的会报时区错误 utilize time zone support.
        String url="jdbc:mysql://localhost:3306/renren_fast?&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";

        // 1、加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2、获取数据库连接
        Connection conn = DriverManager.getConnection(url, "root", "1234");

        // 3、获取数据库操作对象
        Statement statement = conn.createStatement();

        // TODO: 2019/12/1 开启事务
//        conn.setAutoCommit(false);


        // 4、定义操作的 SQL 语句
        String sql = "select * from sys_menu";

        // 5、执行数据库操作
        ResultSet resultSet = statement.executeQuery(sql);
        // TODO: 2019/12/1  提交事务
//        conn.commit();

        // TODO: 2019/12/1 回滚事务 一般是写在try catch里面
//        conn.rollback();
        // 6、获取并操作结果集
        while (resultSet.next()) {
            // 解析结果集
            System.out.println(resultSet.getString("name"));

        }


    }


}
