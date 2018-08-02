package producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*@ClassName:Station
 @Description:TODO
 @Author:
 @Date:2018/7/30 16:06 
 @Version:v1.0
*/
public class Station {
    public static void main(String[] args) {
        //创建一个阻塞队列
        ArrayBlockingQueue<String> tickets = new ArrayBlockingQueue<>(10);
        /*new Thread(new Producer(tickets)).start();
        new Thread(new Consumer(tickets)).start();*/
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            if (i%2==0){
                pool.submit(new Producer(tickets));
            }else{
                pool.submit(new Consumer(tickets));
            }
        }
    }
}
