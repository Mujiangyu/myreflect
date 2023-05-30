package com.niit.myreflect05;

public class Student5 {
    private String name;
    private int age;

    public Student5() {
    }

    public Student5(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void study(){
        System.out.println(this.name+"正在学习");
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student5{name = " + name + ", age = " + age + "}";
    }
}
