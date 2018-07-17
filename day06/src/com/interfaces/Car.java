package com.interfaces;

/*
*@ClassName:Car
 @Description:TODO
 @Author:
 @Date:2018/7/13 15:10 
 @Version:v1.0
*/
//让汽车实现漂移的功能
/*
/*

    接口其实一种最抽象的抽象类
    在接口中定义的方法默认就是pulic
    接口可以多实现，因此接口更加灵活
    

 */
public class Car implements Shift,Fly{
    @Override
    public void safe() {

    }

    public void shift(){
        System.out.println("玩命shift");
    }

    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
