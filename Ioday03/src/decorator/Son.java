package decorator;

/*
*@ClassName:Son
 @Description:TODO
 @Author:
 @Date:2018/7/26 9:40 
 @Version:v1.0
*/
public class Son extends Father {
    @Override
    public void eat() {
        System.out.println("听音乐");
        super.eat();
        System.out.println("来一根");
    }
}
