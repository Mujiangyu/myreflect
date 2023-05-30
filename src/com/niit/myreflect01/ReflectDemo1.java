package com.niit.myreflect01;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        * 获取class对象的三种方式:
        *   Class.forname("全类名")
        *   类名.class
        *   对象.getClass()
        * */

        //1.最为常用
        Class clazz1 = Class.forName("com.niit.myreflect01.Student1");
        System.out.println(clazz1);

        //2.
        Class clazz2 = Student1.class;
        System.out.println(clazz2);

        //3.当已经有了这个类的对象时，才可以使用
        Student1 s = new Student1();
        System.out.println(s.getClass());
    }
}
