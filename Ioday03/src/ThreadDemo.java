/*
*@ClassName:ThreadDemo
 @Description:TODO
 @Author:
 @Date:2018/7/26 11:44 
 @Version:v1.0
*/
public class ThreadDemo {
    //main所在的线程称之为守护线程
    public static void main(String[] args) {
        //通过匿名内部类创建一个runnable对象
        Runnable run1 = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println("helloworld");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
       //通过将runable接口对象传入thread的构造方法来真正的创建线程
        Thread thread = new Thread(run1);
        //启动线程
        thread.start();


        //通过匿名内部类创建一个runnable对象
        Runnable run2 = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println("hellohenan");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //通过将runable接口对象传入thread的构造方法来真正的创建线程
        Thread thread2 = new Thread(run2);
        //启动线程
        thread2.start();




    }
}
