package com.example.demo.java学习.适配器设计模式;

public class DemoTest {
    public static void main(String[] args) {

        // TODO: 2019/11/21 简化程序的操作 一般用作安卓开发比较多
        Boutton boutton = new Boutton();
        boutton.addMounseisten(new ButoonAdpot() {
            @Override
            public void oneClick() {
                System.out.println("只需要实现一个方法， 不需要全部都实现");
            }
        });

    }
}



interface MouseListner{
    public void  oneClick(); // 单击
    public void  doubleClick(); // 单击
    public void  rightClick(); // 单击
}


// TODO: 2019/11/21 实现监听器  监听器定义成抽象方法   方法体都是空实现
abstract  class ButoonAdpot implements MouseListner{
    @Override
    public void oneClick() {

    }

    @Override
    public void doubleClick() {

    }

    @Override
    public void rightClick() {

    }
}


class  Boutton{

    public void addMounseisten(MouseListner mouseListner){}

}