package homework;

/*
*@ClassName:Car
 @Description:TODO
 @Author:
 @Date:2018/7/17 9:07 
 @Version:v1.0
*/
public class Bicycle extends Vehicle {
    @Override
    public void speedUp(int speed) {
        System.out.println("当前时速："+speed+"加速到"+(speed++));
    }

    @Override
    public void speedDown(int speed) {
        System.out.println("当前时速："+speed+"减速到"+(speed--));
    }
}
