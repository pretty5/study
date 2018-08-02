package chatroom;

import java.io.*;
import java.net.Socket;

/*
*@ClassName:OutputHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:24
 @Version:v1.0
*/
//用来将客户端消息发送到服务端的线程
public class ClientMessageOutputHandler implements Runnable {
    private Socket client;

    public ClientMessageOutputHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {

            //定义输出的对象流
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            //来自键盘的输入流
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                //读取输入的一行数据
                String line = keyBoard.readLine();
                String[] strings = line.split(":");
                //对输入做校验
                if (!line.contains("@")||strings.length!=2){
                    System.out.println("输入有误，请继续输入");
                    continue;
                }
                Message message = new Message();
               // @192.168.40.84:e
                message.setContent(strings[1]);
                //设置发送方
                message.setSender(client.getLocalAddress().getHostAddress());
                //设置接收方
                message.setReceiver(strings[0].substring(1));
                //将对象发送输出
                oos.writeObject(message);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
