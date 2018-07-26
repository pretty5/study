/*
*@ClassName:MyRunnable
 @Description:TODO
 @Author:
 @Date:2018/7/26 14:11 
 @Version:v1.0
*/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
