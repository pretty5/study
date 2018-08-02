package producerconsumer;

import java.util.concurrent.BlockingQueue;

/*
*@ClassName:Producer
 @Description:TODO
 @Author:
 @Date:2018/7/30 15:55 
 @Version:v1.0
*/
public class Producer implements Runnable {
    //阻塞队列
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            try {
                //当往阻塞队列中放数据时，如果队列已满，则当前线程会阻塞等待，直到队列可以存放元素
                queue.put(Thread.currentThread().getName()+"ticket"+(i++));
                System.out.println(Thread.currentThread().getName()+"ticket"+i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
