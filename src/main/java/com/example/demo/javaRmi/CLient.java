package com.example.demo.javaRmi;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CLient {
    public static void main(String args[]) {
        try {
            // 填写服务器ip   如果是在其他服务器中 则他们的包名和类的名字必须一样的才能调用
            IHello rhello = (IHello) Naming.lookup("rmi://127.0.0.1:8888/RHello");
//            HelloImpl rhello = new HelloImpl();
            System.out.println(rhello.sayHelloToSomeBody("My first rpc"));
        } catch (NotBoundException e) {
        } catch (MalformedURLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
