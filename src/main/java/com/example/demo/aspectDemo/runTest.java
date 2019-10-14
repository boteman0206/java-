package com.example.demo.aspectDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class runTest {

    @Autowired
    private CalcService calcService;

    @Test
    public void contextLoads() {
        int add = calcService.add(1, 2);  // 可以测试异常的捕获
        System.out.println("我是返回的值 = " + add);

    }
}