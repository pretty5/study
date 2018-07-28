package syn;

/*
*@ClassName:Station
 @Description:TODO
 @Author:
 @Date:2018/7/27 15:10 
 @Version:v1.0
*/
public class Station {
    public static void main(String[] args) {
        int[] tickets = new int[10];
        new Thread(new TicketProducer(tickets)).start();
        new Thread(new TicketSeller(tickets)).start();
    }
}
