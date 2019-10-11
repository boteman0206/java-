package com.example.demo.javaRmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class AnotherTestImpl extends UnicastRemoteObject implements AnotherTest {

    public AnotherTestImpl() throws RemoteException {
        super();
    }

    @Override
    public List getList(String someBodyName) throws RemoteException {
        System.out.println("这里调用了getList方法");
        List list = new ArrayList();
        list.add(someBodyName);
        list.add("tagName");
        list.add("keyWords");
        return list;
    }
}
