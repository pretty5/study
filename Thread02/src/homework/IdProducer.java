package homework;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;



/*
*@ClassName:IdProducer
 @Description:TODO
 @Author:
 @Date:2018/7/31 9:30 
 @Version:v1.0
*/
public class IdProducer implements Runnable{
    private BlockingQueue<String> queue;

    public IdProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                queue.put(generateUUID());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//获取唯一id  uuid
    private String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
