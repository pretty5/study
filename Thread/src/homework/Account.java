package homework;

/*
*@ClassName:Account
 @Description:TODO
 @Author:
 @Date:2018/7/28 10:07 
 @Version:v1.0
*/
public class Account {
    private int money;
    public synchronized void save(int cash){
        money+=cash;
    }
    public synchronized void take(int cash){
        money-=cash;
    }
}
