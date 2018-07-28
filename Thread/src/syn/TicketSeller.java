package syn;

import java.util.Random;

/*
*@ClassName:TicketSeller
 @Description:TODO
 @Author:
 @Date:2018/7/27 14:44 
 @Version:v1.0
*/
public class TicketSeller implements Runnable {
    private int[] tickets;

    public TicketSeller(int[] tickets) {
        this.tickets=tickets;
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(new Random().nextInt(1000)+500);
                sell(tickets);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sell(int[] tickets) throws InterruptedException {
        synchronized (tickets){
            for (int i = tickets.length - 1; i > -1; i--) {
                //如果当前位置没有票则看前面的位置有没有票，如果i==0,说明票仓没票，需要等待票仓有票。
                if (tickets[i] == 0 && i != 0) {
                    continue;
                }
                if (tickets[i]==0 && i==0){
                    System.out.println("票仓没票，需要等待");
                    tickets.wait();
                    System.out.println("票仓有票，卖出编号为 "+i);
                    tickets[i]=0;
                    return;
                }
                if (tickets[i]==1){
                    tickets[i]=0;
                    System.out.println("票仓有票，卖出编号为 "+i);
                    //票仓已经不满了，可以去放票了
                    if (i==tickets.length-1){
                        System.out.println("票仓可以放票了");
                        tickets.notify();
                    }
                    return;
                }


                //if (tickets[tickets.length-i-1])
            }
        }

    }
}
