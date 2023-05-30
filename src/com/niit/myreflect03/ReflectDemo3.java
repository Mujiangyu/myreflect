package com.niit.myreflect03;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        /*
        * Class类中获取成员变量的方法
        *       Field[] getFields()
        *       Field[] getDeclaredFields()
        *       Field[] getField(String name)
        *       Field[] getDeclaredField(String name)
        * */
        //获取字节码文件对象
        Class<?> aClass = Class.forName("com.niit.myreflect03.Student3");

        //获取成员变量的对象
        Field[] f1 = aClass.getFields();//获取的是公共的成员变量-->public
        System.out.println(Arrays.toString(f1));
        Field[] f2 = aClass.getDeclaredFields();//获取所有的成员变量，包括私有变量
        System.out.println(Arrays.toString(f2));

        //获取单个的成员变量
       /* Field f3 = aClass.getField("gender");//只能获取公共的成员变量
        System.out.println(f3);*/
        Field f4 = aClass.getDeclaredField("gender");//获取任意权限的成员变量
        System.out.println(f4);
        System.out.println("------------------------------");

        //获取到成员变量的权限修饰符
        int modifiers = f4.getModifiers();
        System.out.println(modifiers);

        //获取到成员变量名
        String name = f4.getName();
        System.out.println(name);

        //获取成员变量的数据类型
        Class<?> type = f4.getType();
        System.out.println(type);

        //获取成员变量的值(首先应该创建该类的具体实例)
        Student3 stu = new Student3("zhangsan",23,"男");
        f4.setAccessible(true);
        Object value = f4.get(stu);
        System.out.println(value);

        //修改成员变量中记录的值
        f4.set(stu,"女");
        Object newValue = f4.get(stu);
        System.out.println(newValue);


    }
}
