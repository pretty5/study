package dynamicProxy;

/*
*@ClassName:Bird
 @Description:TODO
 @Author:
 @Date:2018/8/7 10:46 
 @Version:v1.0
*/
public class Bird implements Fly {
    public void fly() {
        System.out.println("bird can fly");
    }

    public void eat() {
        System.out.println("bird can eat");

    }
}
