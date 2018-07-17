package com.enums;

/*
*@ClassName:EnumTest
 @Description:TODO
 @Author:
 @Date:2018/7/13 14:35 
 @Version:v1.0
*/
public class EnumTest {
    public static void main(String[] args) {
        for (Season season:
             Season.values()) {
            System.out.println(season.toString());
        }
        Season season=Season.SPRING;


    }
}
