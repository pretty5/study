package com.zhiyou100;

public class SingletonTest {
    public static void main(String[] args) {
        //Dog dog = Dog.getInstance();
        //dog.setName("xiaohei");
        Dog dog2 = Dog.getInstance();
        dog2.setName("xiaohuang");
        Dog dog3 = Dog.getInstance();
        //dog2.setName("xiaohuang");
        System.out.println(dog3.getName());

    }
}
