package com.homework;

/*
*@ClassName:Person
 @Description:TODO
 @Author:
 @Date:2018/7/13 9:06
 @Version:v1.0
*/
public class Person {
    private String name;
    private int age;

    @Override
    public int hashCode() {
        return name.hashCode()+age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //构造方法
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        //判断obj所指向的对象是否是person
        if (obj instanceof Person) {

            //return ((Person) obj).age == this.age && ((Person) obj).name.equals(this.name);
            Person that = (Person) obj;
            if (this.age==that.age && this.name.equals(that.name)){
                return true;
            }
        }

        return false;
    }
}
