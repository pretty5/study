package homework;

/*
*@ClassName:Woman
 @Description:TODO
 @Author:
 @Date:2018/7/28 10:14 
 @Version:v1.0
*/
public class Woman implements Runnable {
    private Account account;

    public Woman(Account account) {
        this.account=account;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("出去3000,老公请赚钱");
            account.take(3000);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
