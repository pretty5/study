package com.zhiyou100;

public class InitBlockTest {
    private  String name;
    private  int age;
    {
        System.out.println("init block run");
    }
    {
        System.out.println("init block2 run");
        age = 10;
    }
}
