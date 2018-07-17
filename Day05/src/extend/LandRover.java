package extend;

/*
*@ClassName:LandRover
 @Description:TODO
 @Author:
 @Date:2018/7/12 14:17 
 @Version:v1.0
*/
public class LandRover extends Car {
    @Override
    public void runto(String dst) {
        super.runto(dst);
        System.out.println("翻山越岭去");
    }
}
