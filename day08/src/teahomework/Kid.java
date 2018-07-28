package teahomework;

/*
*@ClassName:Kid
 @Description:TODO
 @Author:
 @Date:2018/7/18 9:03 
 @Version:v1.0
*/
public class Kid{

    public static Play f1() {

        return new Play() {
            @Override
            public void swim() {
                System.out.println("i can swim");
            }
        };
    }
}
