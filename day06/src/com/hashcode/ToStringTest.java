package com.hashcode;

import com.homework.Person;

/*
*@ClassName:ToStringTest
 @Description:TODO
 @Author:
 @Date:2018/7/13 11:49 
 @Version:v1.0
*/
public class ToStringTest {

    public static void main(String[] args) {
        String s1="hello";
        String s2="hello";
        System.out.println(s1.toString());

        Person jack = new Person("jack", 12);

        System.out.println(jack.toString());

        System.out.println(jack.hashCode());
    }
}
