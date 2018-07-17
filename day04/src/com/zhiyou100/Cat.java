package com.zhiyou100;

public class Cat {
    private String name;
    private int age;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    private Cat() {
    }

    public static void main(String[] args) {
        Cat tom = new Cat("tom");

        Cat jerry = new Cat("jerry",2,"yellow");


        System.out.println(jerry.getName()+jerry.getColor()+jerry.getAge());

        Cat cat = new Cat();
        cat.setName("rose");
        System.out.println(cat.getName());
    }
}
