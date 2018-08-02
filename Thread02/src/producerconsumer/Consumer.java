package producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
*@ClassName:Consumer
 @Description:TODO
 @Author:
 @Date:2018/7/30 16:01 
 @Version:v1.0
*/
public class Consumer implements Runnable {
    //阻塞队列
    private BlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> tickets) {
        this.queue=tickets;
    }

    @Override
    public void run() {
        while (true){
            try {
                //当线程向队列中取数据时，如果没有，则线程阻塞等待，直到有数据可取。
                String ticket = queue.take();
                System.out.println(Thread.currentThread().getName()+" get "+ticket);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
