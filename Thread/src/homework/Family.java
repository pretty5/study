package homework;

/*
*@ClassName:Family
 @Description:TODO
 @Author:
 @Date:2018/7/28 10:16 
 @Version:v1.0
*/
public class Family {
    public static void main(String[] args) {
        Account account = new Account();
        Man haonanren = new Man(account);
        Woman haonvren = new Woman(account);
        new Thread(haonanren).start();
        new Thread(haonvren).start();

    }
}
