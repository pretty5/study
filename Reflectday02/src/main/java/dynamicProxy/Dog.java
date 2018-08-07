package dynamicProxy;

/*
*@ClassName:Dog
 @Description:TODO
 @Author:
 @Date:2018/8/7 11:22 
 @Version:v1.0
*/
public class Dog implements Fly {
    public void fly() {
        System.out.println("dog can fly");
    }

    public void eat() {
        System.out.println("dog can eat");

    }
}
