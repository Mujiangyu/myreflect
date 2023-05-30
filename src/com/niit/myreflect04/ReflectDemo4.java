package com.niit.myreflect04;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*
         * Class类中用于获取成员方法的方法
         *       Method[] getMethods()
         *       Method[] getDeclaredMethods()
         *       Method[] getMethod(String name,Class<?>...parameterTpyes)
         *       Method[] getDeclaredMethod(String name,Class<?>...parameterTpyes)
         *
         * */

        //获取class字节码文件的对象
        Class<?> aClass = Class.forName("com.niit.myreflect04.Student4");

        //获取到所有公共方法(包含父类中所有的公共方法)
        Method[] m1 = aClass.getMethods();
        for (Method method : m1) {
            System.out.println(method);
        }
        System.out.println("=======================================");
        //只能获取到在当前类中定义的方法，不包含从父类中继承的方法，可以获取本类中的私有方法
        Method[] m2 = aClass.getDeclaredMethods();
        for (Method method : m2) {
            System.out.println(method);
        }
        //获取单个的成员方法，参数一：方法名；参数二：方法的形参
        Method m3 = aClass.getDeclaredMethod("eat", String.class);
        System.out.println(m3);
        System.out.println("==================================");
        //获取方法的修饰符
        int modifiers = m3.getModifiers();
        System.out.println(modifiers);
        //获取方法的名字
        String name = m3.getName();
        System.out.println(name);
        //获取方法的形参个数
        int count = m3.getParameterCount();
        System.out.println(count);
        //获取参数的类型，和参数的对象
        Parameter[] parameters = m3.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        //获取到方法的返回值,只有在方法运行之后才能获取

        //获取方法抛出的异常
        Class[] exceptionTypes = m3.getExceptionTypes();
        System.out.println(Arrays.toString(exceptionTypes));

        //运行获取到的方法
        /*
        * Object invoke(Object obj,Object...args):运行方法
        * 参数一：用obj对象调用该方法，即方法的调用者
        * 参数二：调用方法的传递的参数，被调用方法的形参啊
        * 返回值：方法的返回值，如果有返回值，需要接收返回值，如果没有则不需要多余的处理
        * */
        Student4 stu = new Student4("zhangsan",23);
        m3.setAccessible(true);
        m3.invoke(stu,"苹果");


    }
}
