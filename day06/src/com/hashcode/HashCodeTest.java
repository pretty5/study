package com.hashcode;

/*
*@ClassName:HashCodeTest
 @Description:TODO
 @Author:
 @Date:2018/7/13 11:31 
 @Version:v1.0
*/
//用来测试hashcode
public class HashCodeTest {
    public static void main(String[] args) {
        //
        String s1="hello";
        String s2="hello";
        String s3="world";
        String s4="hello1";
        Object s5="hello1";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

    }
}
