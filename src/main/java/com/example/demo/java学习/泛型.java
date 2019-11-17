package com.example.demo.java学习;



public class 泛型 {
    public static void main(String[] args) {
//        不用泛型可以调用
        fanxin f1 = new fanxin();
        System.out.println(f1.test());


//        使用泛型
        fanxin<String> f2 = new fanxin<>();
        f2.setPara("name");
        String para = f2.getPara();
        System.out.println(para);


//        ？ 表示任意类型 一般在定义方法限定参数来使用
//        ？ extend E （向下限定 添加的类型可以使E类型或者E类型的子类）
//        ？ super E  （向上限定 E是父类 ？是子类 E及其E的父类）
    }
}

// todo 自定义泛型
class fanxin<T>{
   private T para;

   public T test(){
        return null;
    }

    public T getPara() {
        return para;
    }

    public void setPara(T para) {
        this.para = para;
    }
}