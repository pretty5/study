package extend;

/*
*@ClassName:InstanceOfTest
 @Description:TODO
 @Author:
 @Date:2018/7/12 14:36 
 @Version:v1.0
*/
//测试instanceof关键字
//instance：实例
//instanceof 判断一个对象是否是某种类型
public class InstanceOfTest {
    public static void main(String[] args) {

        Car car = new Car();

        Car benz = new Benz();

        Car rover = new LandRover();

        if (car instanceof Car){
            System.out.println("是car类型");
        }
        if (benz instanceof Car){
            System.out.println("是car类型");
        }
        if (rover instanceof Car){
            System.out.println("是car类型");
        }

        if (benz instanceof Benz){
            System.out.println("是benz类型");
        }
        if (rover instanceof LandRover){
            System.out.println("是landrover类型");
        }
        if (benz instanceof LandRover){
            System.out.println("是benz类型");
        }else{
            System.out.println("不是");
        }
        if (rover instanceof Benz){
            System.out.println("是landrover类型");
        }else{
            System.out.println("不是");
        }


    }
}
