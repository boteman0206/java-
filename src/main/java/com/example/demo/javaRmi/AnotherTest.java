package com.example.demo.javaRmi;

import javax.validation.constraints.Max;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AnotherTest  extends Remote {

    public List getList(String someBodyName) throws RemoteException;
}
