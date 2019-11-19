package com.example.demo.java学习;



public class 单例模式 {

}



//饿汉方式
class singletonHanger{
    private static singletonHanger singletonHanger = new singletonHanger();
    private singletonHanger(){};

    public static singletonHanger getInstance(){
        return singletonHanger;
    }
}

//懒汉方式  线程不安全
class singletonBao{
    private static singletonBao singletonBao;
    private singletonBao(){};

    public static singletonBao getInstance(){
        if (singletonBao == null){
            singletonBao = new singletonBao();
        }
        return singletonBao;
    }
}


//方式三
class singletonSan{
    private static final singletonSan sin = new singletonSan();
    public static singletonSan getInstance(){
        return sin;
    }
}

