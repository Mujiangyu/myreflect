package com.niit.myreflect05;

public class Teacher5 {
    private String name;
    private double salary;

    public Teacher5() {
    }

    public Teacher5(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void teach(){
        System.out.println(this.name+"正在上课");
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
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Teacher5{name = " + name + ", salary = " + salary + "}";
    }
}
