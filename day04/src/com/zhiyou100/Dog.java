package com.zhiyou100;


//实现单例模式  在内存中只有一个词类型的对象
public class Dog {
    //内部定义一个属性
    private static Dog dog=new Dog();

    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    //私有构造方法  不能通过new创建对象
    private Dog(){
    }
    //定义公开静态方法
    public static Dog getInstance(){

        return dog;
    }
}
