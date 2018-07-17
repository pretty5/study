package extend;

/*
*@ClassName:Benz
 @Description:TODO
 @Author:
 @Date:2018/7/12 14:16 
 @Version:v1.0
*/
public class Benz extends Car {
    @Override
    public void runto(String dst) {
        super.runto(dst);
        System.out.println("装逼的去，我是奔驰");
    }
}
