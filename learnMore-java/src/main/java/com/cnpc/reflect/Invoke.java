package com.cnpc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/11 14:34
 */
public class Invoke {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ServerDevice serverDevice = new ServerDevice();
        serverDevice.setCpu("1");
        Method[] methods = serverDevice.getClass().getDeclaredMethods();
        for(Method method  : methods){
            if(method.getName().contains("get"))
            {
                Object value = method.invoke(serverDevice,null);
                System.out.println(value);
            }else {
                method.invoke(serverDevice,new Object[]{"1"});
            }

        }
    }

}
