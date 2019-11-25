package com.example.demo.JDBC常用操作;

import java.sql.*;

public class PreparedStatement的使用 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url= "jdbc:mysql:///renren_fast?&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String name= "root";
        String password= "1234";
        Connection connection = DriverManager.getConnection(url, name, password);

//        String sql = "select * from sys_user";
        //        Statement statement = connection.createStatement();
        //        ResultSet execute = preparedStatement.executeQuery(sql);
//        while (execute.next()){
//            System.out.println(execute.getObject("username"));
//        }
        // TODO: 2019/11/24  使用  PreparedStatement 方法
        // todo 插入数据方法
//        String  sql = "insert  into sys_user (username, password) values (?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, "jack");
//        preparedStatement.setString(2, "123");
//
//        int i = preparedStatement.executeUpdate(); // todo 执行插入的操作 返回受到影响的行数
//        System.out.println("受影响的行数 = " + i);

        //       todo 更新数据库数据
//        String upstr = "update sys_user set password = ? where username=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(upstr);
//        preparedStatement.setString(1, "7897979");
//        preparedStatement.setString(2, "jack");
//        int i = preparedStatement.executeUpdate();
//        System.out.println("受影响的行数 = " + i);

        // TODO: 2019/11/24 删除数据库数据
//        String sql = "delete from sys_user where username=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, "jack");
//        int i = preparedStatement.executeUpdate();
//        System.out.println("受影响的行数 = " + i);

        // TODO: 2019/11/24 查询数据 进行封装
        User user = new User();
        String sql = "select * from sys_user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user.setUsername(String.valueOf(resultSet.getObject("username")));
            user.setPassword(String.valueOf(resultSet.getObject("password")));
            System.out.println(user);
        }

//        关闭连接

    }
}
