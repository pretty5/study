package com.zhiyou100;

import static jdk.nashorn.internal.objects.NativeRegExp.test;
//测试按值传递
public class ValueTest {
    private  String name;
    private  int height;

    public   void set(String name, int height ){
        this.name = name;
        this.height = height;

    }

    public static void main(String[] args) {
        String s = "tom";
         int age=10;
        test1("rose",6);
        System.out.println(s);
        System.out.println(age);
    }

    private static void test1(String s, int age) {
        s ="jack";
        age = 100;
    }
}
