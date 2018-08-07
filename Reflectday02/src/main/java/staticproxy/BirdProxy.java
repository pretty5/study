package staticproxy;

/*
*@ClassName:BirdProxy
 @Description:TODO
 @Author:
 @Date:2018/8/7 10:39 
 @Version:v1.0
*/
/*
    代理模式是一种设计模式，分为动态代理和静态代理
    类似于装饰模式，都是用来在不改变原来类的情况下，增强原来类的功能。
    静态代理：继承父类，重写父类方法，在父类方法前或者方法后可以执行操作。
    静态代理缺点：对于类过多的情况，会生成过多的代理类。


 */
public class BirdProxy extends Bird {
    @Override
    public void fly() {
        System.out.println("i can sing");
        super.fly();
        System.out.println("i can dance");
    }
}
