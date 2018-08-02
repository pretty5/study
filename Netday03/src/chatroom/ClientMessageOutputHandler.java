package chatroom;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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

    private ChatClient client;

    public ClientMessageOutputHandler(ChatClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //来自键盘的输入流
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                //读取输入的一行数据
                String line = keyBoard.readLine();
                //做判断如果输入为list
                if (line.equals("list")){
                    Message message = new Message();
                    message.setType(3);
                    message.setSender(client.getSocket().getLocalAddress().getHostAddress());
                    client.getOos().writeObject(message);
                    continue;
                }
                //做判断如果输入为exit
                if (line.equals("exit")){
                    Message message = new Message();
                    message.setType(2);
                    message.setSender(client.getSocket().getLocalAddress().getHostAddress());
                    client.getOos().writeObject(message);
                    //退出jvm
                    System.exit(0);
                    //continue;
                }

                String[] strings = line.split(":");
                //对输入做校验
                if (!line.contains("@")||strings.length!=2){
                    System.out.println("输入有误，请继续输入");
                    continue;
                }
                Message message = new Message();
                //设置消息类型
                message.setType(1);
               // @192.168.40.84:e
                message.setContent(strings[1]);
                //设置发送方
                message.setSender(client.getSocket().getLocalAddress().getHostAddress());
                //设置接收方
                message.setReceiver(strings[0].substring(1));
                //将对象发送输出
                client.getOos().writeObject(message);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
