package com.niit.myreflect04;

import java.io.IOException;

public class Student4 {
    private String name;
    private int age;

    public Student4() {
    }

    public Student4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    private void eat(String something) throws IOException,ArrayIndexOutOfBoundsException {
        System.out.println(this.name+"在吃" + something);
    }

    public String toString() {
        return "Student4{name = " + name + ", age = " + age + "}";
    }
}
