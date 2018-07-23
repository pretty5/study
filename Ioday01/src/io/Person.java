package io;

import java.io.Serializable;

/*
*@ClassName:Person
 @Description:TODO
 @Author:
 @Date:2018/7/23 15:12 
 @Version:v1.0
*/
/*
    Serializable序列化接口，是一个标记接口（没有方法定义）。
    告诉jvm这个对象可以被序列化

 */
public class Person implements Serializable {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
