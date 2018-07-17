package com.homework;

/*
*@ClassName:SmartPhone
 @Description:TODO
 @Author:
 @Date:2018/7/13 9:23 
 @Version:v1.0
*/

public class SmartPhone extends Phone {

    public void playMusic(){
        System.out.println("i can play music");
    }
    //上网
    public void surfInternet(){
        System.out.println("i can surfInternet");
    }
    @Override
    public void call() {
        System.out.println("call somebody");
    }

    @Override
    public void sendMessage() {
        System.out.println("send message to somebody");
    }
}
