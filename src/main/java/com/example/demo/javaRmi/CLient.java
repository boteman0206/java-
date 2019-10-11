package com.example.demo.javaRmi;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CLient {
    public static void main(String args[]) {
        try {
            // 填写服务器ip
            IHello rhello = (IHello) Naming.lookup("rmi://127.0.0.1:8888/RHello");
            AnotherTest anotherTest = (AnotherTest) Naming.lookup("rmi://127.0.0.1:8888/AHello");
//            HelloImpl rhello = new HelloImpl();
            System.out.println(rhello.sayHelloToSomeBody("My first rpc"));
            System.out.println(anotherTest.getList("jack"));
        } catch (NotBoundException e) {
        } catch (MalformedURLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
