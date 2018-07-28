package teahomework;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/17 9:00 
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) {
        //创建一个轮胎
        Tyre tyre = new Tyre();
        tyre.setPa(100);

        //创建一个汽车
        Vehicle car = new Car();

        car.setTyre(tyre);

        Vehicle bicycle = new Bicycle();

        bicycle.setTyre(tyre);

        //创建一个修理工

        RepairMan xiaowang = new RepairMan();

        xiaowang.repairTyre(car);

    }

}
