package com.example.demo.使用SPEL表达式;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;



@Configuration
@PropertySource (name = "employeeProperties", value = "employee.properties")
@ConfigurationProperties
public class employeeConfig {

    @Value("#{'${employee.names}'.split(',')}")
    public static List<String> employeeNames;



}
