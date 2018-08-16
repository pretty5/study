package homework.log;

/*
*@ClassName:FactoryTest
 @Description:TODO
 @Author:
 @Date:2018/8/15 9:38 
 @Version:v1.0
*/
public class FactoryTest {
    public static void main(String[] args) {
        Car benz = CarFactory.getCar("benz");
        benz.drive();
        Car bmw = CarFactory.getCar("bmw");
        bmw.drive();

        Car benz1 = new Benz();

    }
}
