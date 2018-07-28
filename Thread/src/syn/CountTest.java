package syn;

/*
*@ClassName:CountTest
 @Description:TODO
 @Author:
 @Date:2018/7/27 9:19 
 @Version:v1.0
*/
/*
synchornized java的中关键字  可加在代码块上 方法上 表示同步的意思

对于需要同步的静态资源，对其只能加静态类型的锁，称之为class锁或者类锁

 */
public class CountTest {
    static int count=0;
    static  int[] lockArr=new int[3];
    static Object lock=new Object();


    public static void main(String[] args) throws InterruptedException {
        //单线程方式  传统方式
       //way1();
        //多线程方式
        way2();
        //Class<CountTest> countTestClass = CountTest.class;
    }

    private static void way2() throws InterruptedException {
        //第一个线程  加5000次
        new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized加在代码块上  称之为同步代码块

                synchronized (CountTest.class){
                    for (int i = 0; i < 50000; i++) {
                        count++;
                        System.out.println(Thread.currentThread().getName());
                    }
                }

            }
        }).start();
        //第二个线程  加5000次
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (CountTest.class){
                    for (int i = 0; i < 50000; i++) {
                        count++;
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }).start();

        Thread.sleep(2000);

        System.out.println(count);
    }

    private static void way1() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println(count);
    }
}
