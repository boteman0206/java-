package com.example.demo.设计模式.代理模式;

public class cglibTest {
    public static void main(String[] args){

        Java3y java3y = new Java3y();
        CglibProxy cglibProxy = new CglibProxy();

        Java3y buyHouseCglibProxy = (Java3y) cglibProxy.getInstance(java3y);

        buyHouseCglibProxy.speaking();

    }


}
