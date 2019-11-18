package com.example.demo.java学习;

public class 异常的常用方法 {
    public static void main(String[] args) throws Exception {
        try{
            int a =  10 / 9 ;
            return;
        }catch (Exception e){
//            System.out.println(e.toString()); // 异常的信息
//            System.out.println(e.getMessage()); //异常的类型+信息
            e.printStackTrace(); // jvm虚拟机处理的异常 用的比较多
            throw new Exception("异常抛出去给别人处理"); //todo 别人调用的方法的时候需要自己去处理
//            可以try catch 也可以 继续throws

        }
        finally {
            // TODO: 有return还是会执行finally里面的代码 先执行代码再去return
            // TODO: 2019/11/18 但是在finally里面不能修改return的值
            System.out.println("我还会执行吗");
        }

    }



    public static void test(){

        try{

        }catch (RuntimeException e){

        }
    }
}


// todo 自定义异常 提供一个带字符串的构造方法 编译异常
class MyException extends Exception{
    MyException(String msg){
        super(msg);
    }

}

// todo 自定义运行时的异常 这个也是集成Exception
class MyRunTimeException extends RuntimeException{
    MyRunTimeException(String msg){
        super(msg);
    }
}