package decorator;

/*
*@ClassName:BufferTest
 @Description:TODO
 @Author:
 @Date:2018/7/26 9:41 
 @Version:v1.0
*/
public class BufferTest {
    public static void main(String[] args) {
        //testUseExtends();
        testUseDecorator();
    }

    private static void testUseDecorator() {
        //被装饰（增强）对象
        Father father = new Father();
        //创建一个装饰器
        FatherDec fatherDec = new FatherDec(father);
        //调用被装饰对象的方法
        fatherDec.eat();

        //创建一个被装饰对象
        Father girl = new Girl();
        //创建一个装饰器
        FatherDec girlDec = new FatherDec(girl);

        girlDec.eat();
    }

    private static void testUseExtends() {
        Father father = new Father();
        Son son = new Son();
        /*father.eat();
        son.eat();*/
        watchEat(father);
        watchEat(son);
    }
    public static void watchEat(Father person){
        person.eat();
    }

}
