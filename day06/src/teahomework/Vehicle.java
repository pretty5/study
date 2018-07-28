package teahomework;

/*
*@ClassName:Vehicle
 @Description:TODO
 @Author:
 @Date:2018/7/17 9:01 
 @Version:v1.0
*/
public abstract class Vehicle {
    //轮胎
    //private String tyre;
    private Tyre tyre;
    //速度
    private int speed;

   /* public Vehicle(Tyre tyre, int speed) {
        this.tyre = tyre;
        this.speed = speed;
    }*/

    /*public Vehicle() {
    }*/

    //定义加速功能
    public abstract void speedUp(int speed);
    //减速功能
    public abstract void speedDown(int speed);


    //定义set get方法  否则子类无法访问父类的属性

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }


    /*public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }*/

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
