package com.example.demo.aspectDemo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        int result = a / b;
        System.out.println("a:"+a+",b:"+b+",result:"+result);
        return result;
    }
}