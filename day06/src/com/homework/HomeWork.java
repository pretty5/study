package com.homework;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/13 9:03 
 @Version:v1.0
*/

public class HomeWork {
    public static void main(String[] args) {
        //自定义equals方法
        q3();
    }

    /*
    3. 定义Person类。拥有两个属性 name,age。
        要求重写equals方法，依据是当两个人名字，年龄都相等，则认为相等。

     */
    private static void q3() {
        Person tom = new Person("tom", 12);
        Person tom2 = new Person("tom", 12);
        Person tom3 = new Person("tom", 13);
        Person jack = new Person("jack", 12);
        Person jerry = new Person("jerry", 11);
        //测试equals方法，查看结果是否与逾期一致。
        System.out.println(tom.equals(tom2));
        System.out.println(tom.equals(tom3));
        System.out.println(tom.equals(jack));
        System.out.println(tom.equals(jerry));
        System.out.println(tom.equals(1));

    }
}
