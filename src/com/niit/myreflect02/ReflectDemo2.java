package com.niit.myreflect02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        * Class类中获取构造方法的方法
        *       Constructor<?>[] getConstructors()
        *       Constructor<?>[] getDeclaredConstructors()
        *       Constructor<T>[] getConstructor(Class<?>...parameterTypes)
        *       Constructor<T>[] getDeclaredConstructors(Class<?>...parameterTypes)
        * */

        //1.获取字节码文件的对象
        Class<?> aClass = Class.forName("com.niit.myreflect02.Student2");

        //2.获取构造方法
        //此方法只能获取到公共的构造方法
        Constructor<?>[] cons = aClass.getConstructors();
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }
        System.out.println("-------------------");
        //3.获取所有的构造方法
        Constructor<?>[] cons2 = aClass.getDeclaredConstructors();
        for (Constructor<?> con : cons2) {
            System.out.println(con);
        }
        System.out.println("--------------------");
        //4.获取单个构造方法
        //空参表示调用空参的构造方法
        //想要调用哪个构造方法，则方法里面的参数就要和构造方法的参数保持一致
        Constructor<?> cons3 = aClass.getDeclaredConstructor();
        System.out.println(cons3);
        Constructor<?> cons4 = aClass.getDeclaredConstructor(int.class);
        System.out.println(cons4);

        //参数的位置也必须跟构造方法中参数的位置保持一致，否则代码运行也会报错
        Constructor<?> cons5 = aClass.getDeclaredConstructor(String.class,int.class);
        System.out.println(cons5);
        System.out.println("-------------------------------");

        //获取到构造方法的权限修饰符
        int modifiers = cons5.getModifiers();
        System.out.println(modifiers);

        //获取构造方法的参数
        Parameter[] parameters = cons5.getParameters();
        System.out.println(Arrays.toString(parameters));
        System.out.println("----------------------------------");

        //利用获取到的构造方法去创建对象
        //全参构造是私有的，无法在外部使用其构造方法创建对象
        //暴力反射：可以使用下面的放法零食取消权限的校验
        cons5.setAccessible(true);
        Student2 stu = (Student2)cons5.newInstance("zhangsan", 23);
        System.out.println(stu);//IllegalAccessException
    }
}