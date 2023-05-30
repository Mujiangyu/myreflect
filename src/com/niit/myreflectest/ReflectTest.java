package com.niit.myreflectest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        /*
         * 对于任意一个对象，都可以吧对象所有的字段和值，保存到文件中去
         * */
        //创建对象
        StudentTest stu = new StudentTest("norman", 23, '男', 174.3, "music");
        TeacherTest tea = new TeacherTest("mime", 5000);

        saveObject(tea);
    }

    private static void saveObject(Object obj) throws IllegalAccessException, IOException {
        Class aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();
    }
}
