/*
*@ClassName:ThreadDemo
 @Description:TODO
 @Author:
 @Date:2018/7/26 11:44 
 @Version:v1.0
*/
/*
    start:表示线程真正的启动
    run:相当于在main方法main线程中执行一段代码，没有真正的启动线程。
 */
public class ThreadDemo {
    //main所在的线程称之为守护线程
    public static void main(String[] args) throws InterruptedException {
        //testRunnable();
        //testExtends();


        /*HelloThread helloThread = new HelloThread();
        helloThread.start();*/
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);
        thread.setPriority(7);
        thread.start();//1us 100ns
        System.out.println(thread.isAlive());
        System.out.println(thread.isAlive());
        System.out.println(thread.isAlive());
        System.out.println(thread.isAlive());
        Thread.sleep(1000);
        System.out.println(thread.isAlive());
        System.out.println(thread.getId()+thread.getName());
        //thread.start();
        thread.setName("hello");
        System.out.println(thread.getId()+thread.getName());
        System.out.println(thread.getPriority());

        System.out.println(thread.getPriority());
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("hello zhengzhou");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

        //new Thread(new HelloThread());
        //new Thread(new MyRunnable()).start();

    }

    private static void testExtends() {
        new MyThread().start();
        System.out.println("come to here");
        /*MyThread myThread = new MyThread();
        myThread.start();*/
    }

    private static void testRunnable() throws InterruptedException {
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
        //thread.in
        //启动线程
        thread.start();

        Thread.sleep(2000);
        //run1.run();
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
        run2.run();
        //通过将runable接口对象传入thread的构造方法来真正的创建线程
        //Thread thread2 = new Thread(run2);
        //启动线程
        //thread2.start();



    }
}
