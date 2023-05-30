package com.niit.myreflect05;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        * 反射可以与配置文件相结合，动态地创建对象，并调用方法
        * */
        //1.读取配置文件中的信息
        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("prop.properties");

        properties.load(fis);

        fis.close();

        //2.获取全类名和方法名
        String classname = (String)properties.get("classname");

        String methodname = (String)properties.get("method");

        //3.利用反射创建对象和调用方法
        Class<?> aClass = Class.forName(classname);

        Constructor con = aClass.getDeclaredConstructor();

        Object obj = con.newInstance();

        Method method = aClass.getDeclaredMethod(methodname);

        method.setAccessible(true);

        method.invoke(obj);

    }
}
