package com.example.demo.javaRmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHelloToSomeBody(String someBodyName) throws RemoteException {
        System.out.println("Connected sucessfully!");
        return "你好，我只能说你很强势" + someBodyName + "!";
    }
}
