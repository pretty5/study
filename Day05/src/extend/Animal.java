package extend;

/*
*@ClassName:Animal
 @Description:TODO
 @Author:
 @Date:2018/7/12 14:53 
 @Version:v1.0
*/
/*
    类名前加abstract表示抽象类。
    拥有抽象方法的一定是抽象类。
    抽象类不一定拥有抽象方法。
    抽象类不能被实例化
    继承自抽象类的方法必须要实现
 */
public abstract class Animal {
    abstract void eat();
    abstract void sleep();
    public void play(){
        System.out.println("i can play");
    }
}
