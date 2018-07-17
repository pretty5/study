package extend;

/*
*@ClassName:Son
 @Description:TODO
 @Author:
 @Date:2018/7/12 11:36 
 @Version:v1.0
*/
public class Son extends Child {

    public Son(String name, int age) {
        super(name, age);
    }

    @Override
    protected void drive() {
        //super.drive();
        System.out.println("i can drive and i can shift and i can fly");
    }
}
