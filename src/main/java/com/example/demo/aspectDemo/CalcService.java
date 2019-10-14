package com.example.demo.aspectDemo;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public interface CalcService {

    public int add(int a, int b);
}
