package interupt;

/*
*@ClassName:ThreadInterruptTest
 @Description:TODO
 @Author:
 @Date:2018/7/31 14:04 
 @Version:v1.0
*/
/*
    中断是工具，是一种信号，告知线程要做一些处理。
    相对其他的工具，suspend 更安全。
 */
public class ThreadInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("helloworld");
                    //判断当前线程是否被中断 不修改线程中断的状态
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("isinterupted");
                    }
                    //静态方法 判断当前线程是否被中断 修改线程中断的状态
                    if (Thread.interrupted()) {
                        System.out.println("interupted");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }

                   try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        Thread.sleep(1000);

        //thread.interrupt();
        //强制中止线程运行
        //thread.suspend();
        //线程的合并（中止当前线程，让调用方执行，直到调用方执行完毕，才会继续执行当前线程）
        System.out.println("before  join");
        //thread.join();

        //thread.stop();

        System.out.println("hellohenan");

    }
}
