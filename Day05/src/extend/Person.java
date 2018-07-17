package extend;

/*
*@ClassName:Person
 @Description:TODO
 @Author:
 @Date:2018/7/12 14:13 
 @Version:v1.0
*/
public class Person {
    private Car car;
    //String a;

    //人可以旅行
    public void travel(String dst){

        car.runto(dst);
    }

    public Car getCar() {

        return car;
    }

    public void setCar(Car car) {

        this.car = car;
    }

    public static void main(String[] args) {
        Car car = new Car();

        Car benz = new Benz();

        Car rover = new LandRover();
        Person gailun = new Person();
        gailun.setCar(car);
        Person kate = new Person();
        kate.setCar(benz);
        Person zhaoxin = new Person();
        zhaoxin.setCar(rover);
        gailun.travel("土耳其");
        kate.travel("巴黎");
        zhaoxin.travel("东京");


        //Benz car1 = (Benz) car;

        //car1.runto("迈阿密");

        //LandRover rover1 = (LandRover) benz;

        //rover1.runto("迈阿密");

        Benz benz1 = (Benz) benz;

        benz1.runto("迈阿密");

    }
}
