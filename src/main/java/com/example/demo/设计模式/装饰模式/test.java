package com.example.demo.设计模式.装饰模式;



public class test {

    public static void main(String[] args) {
        Phone iphoneX = new IphoneX();

        MusicPhone musicPhone = new MusicPhone(iphoneX);
//        在打电话之前听音乐
//        musicPhone.call();

//        GiveCurrentTimePhone giveCurrentTimePhone = new GiveCurrentTimePhone(iphoneX);

//        在前一个musicPhone基础上增加功能， 打完电话显示当先时间
//        giveCurrentTimePhone.call();

//        将已经增强的对象传递过去
        MusicPhone musicPhone1 = new MusicPhone(iphoneX);
//        GiveCurrentTimePhone giveCurrentTimePhone = new GiveCurrentTimePhone(iphoneX);
        GiveCurrentTimePhone giveCurrentTimePhone = new GiveCurrentTimePhone(musicPhone1);
        giveCurrentTimePhone.call();

    }
}
