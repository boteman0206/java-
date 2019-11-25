package com.example.demo.JDBC常用操作;

import java.nio.channels.ClosedSelectorException;
import java.sql.*;

public class sql的注入问题 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        sql的注入问题不让拼接

        Class.forName("com.mysql.jdbc.Driver");
        String url= "jdbc:mysql:///renren_fast?&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String name= "root";
        String password= "1234";
        Connection connection = DriverManager.getConnection(url, name, password);
        String sql = "select * from sys_user where username= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String user_name = "admin";
        // todo 在这里传入查询的参数 不让用户拼接sql
        preparedStatement.setString(1, user_name);

        ResultSet execute = preparedStatement.executeQuery();
        while (execute.next()){
            System.out.println(execute.getObject("username"));
        }



    }
}
