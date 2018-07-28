package syn;

/*
*@ClassName:CountThread
 @Description:TODO
 @Author:
 @Date:2018/7/27 10:41 
 @Version:v1.0
*/
/*
对于非静态成员的加的锁  称之为this锁。
 */
public class CountThread implements Runnable {

    private Counter counter;
    //计数次数
    private int num;

    public CountThread(Counter counter, int num) {
        this.counter = counter;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            counter.addOne();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //测试非静态字段的同步
        //testNonStaticSyn();
        //测试同步方法
        testSynMethod();

    }

    private static void testSynMethod() {
        //创建一个计数器
        Counter counter = new Counter();
        //创建两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                counter.addOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.addTwo();
            }
        }).start();


    }

    private static void testNonStaticSyn() throws InterruptedException {

        //创建一个计数器
        Counter counter = new Counter();
        //创建两个线程
        new Thread(new CountThread(counter,50000000)).start();
        new Thread(new CountThread(counter,50000000)).start();

        Thread.sleep(5000);

        System.out.println(counter.getCount());
    }
}
