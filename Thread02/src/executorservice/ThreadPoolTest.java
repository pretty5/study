package executorservice;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
*@ClassName:ThreadPoolTest
 @Description:TODO
 @Author:
 @Date:2018/7/30 14:29 
 @Version:v1.0
*/
/*
    为什么有线程池：线程的创建和销毁都是需要占用资源的。频繁的创建和销毁线程会降低系统的系统。
    CachedThreadPool：缓存线程池。保留几个常住的线程，如果常驻的线程完成不了当前的任务，则会创建新的线程去处理任务。
    创建完之后会将创建的线程缓存起来，一段时间如果没有任务，线程池终止。比较占用内存。
    FixedThreadPool:固定数量线程池。线程数量在一开始就固定下来。如果线程池处理不完当前的任务，会将任务加入队列等待直到
    有空闲的线程。
    SingleThreadExecutor:单线程线程池。只有一个线程来处理任务，对于提交的任务按照先后顺序执行。
    ScheduledThreadPool:调度线程池。用于定时调度。
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        boolean empty = StringUtils.isEmpty("");
//       System.out.println(empty);

        //10个线程，0-99每个线程计算i-->i+9
        //创建一个线程池
        //ExecutorService pool = Executors.newCachedThreadPool();
        //ExecutorService pool = Executors.newFixedThreadPool(4);
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        },10,TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello henan");
            }
        },1,1,TimeUnit.SECONDS);

        /*for (int i = 0; i < 999; i++) {
            int tmp = i;
            if (i % 10 == 0) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        int sum = 0;
                        for (int j = tmp; j < tmp + 9; j++) {
                            sum += j;
                        }
                        System.out.println(Thread.currentThread().getName() + " sum: " + sum);
                    }
                });
            }

        }*/

    }
}
