/*
*@ClassName:MyThread
 @Description:TODO
 @Author:
 @Date:2018/7/26 14:05 
 @Version:v1.0
*/
//通过继承的方式创建线程
public class MyThread extends Thread {
    //在run方法 中实现线程的业务逻辑
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
