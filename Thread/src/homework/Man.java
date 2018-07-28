package homework;

/*
*@ClassName:Man
 @Description:TODO
 @Author:
 @Date:2018/7/28 10:11 
 @Version:v1.0
*/
public class Man implements Runnable {
    private Account account;

    public Man(Account account) {
        this.account=account;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("进账5000，老婆请花");
            account.save(5000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
