package syn;

import java.util.Random;

/*
*@ClassName:TicketProducer
 @Description:TODO
 @Author:
 @Date:2018/7/27 14:17 
 @Version:v1.0
*/
//票的生产者
public class TicketProducer implements Runnable {
    //
    private int[] tickets;//

    public TicketProducer(int[] tickets) {
        this.tickets=tickets;
    }

    @Override
    public void run() {
        while (true) {
            try {
                produce(tickets);
                //Thread.sleep(new Random().nextInt(3000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int[] tickets) throws InterruptedException {
        synchronized (tickets){
            for (int i = 0; i < tickets.length; i++) {
                if (i==tickets.length-1&&tickets[i]==1){
                    //释放当前线程的锁，同时让线程中止运行 陷入等待 等待被唤醒
                    System.out.println("票仓已满，等待消费");
                    tickets.wait();
                }
                if (tickets[i] == 1) {
                    continue;
                }else{
                    tickets[i]=1;
                    System.out.println("生产一张票，编号为 "+i);
                    if (i==0){
                        tickets.notify();
                    }
                    return;

                }
            }
        }



    }
}
