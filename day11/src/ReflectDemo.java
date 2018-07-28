import teahomework.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
*@ClassName:ReflectDemo
 @Description:TODO
 @Author:
 @Date:2018/7/21 11:36 
 @Version:v1.0
*/
public class ReflectDemo {
    public static void main(String[] args) {
        Student student = new Student(12, "tom");
        Class<? extends Student> studentClass = student.getClass();
        //student.getName();
        System.out.println(studentClass.getName());
        //获取类的字段名
        Field[] fields = studentClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        //获取这个类所用的所有的方法
        Method[] methods = studentClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }

        //System.out.println();
    }
}
