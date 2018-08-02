package chatroom;

import java.io.*;
import java.net.Socket;
import java.util.Set;

/*
*@ClassName:ServerInputHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:19
 @Version:v1.0
*/
//服务端用来处理客户端输入线程
public class ServerMessageInputHandler implements Runnable {
    private Socket client;

    public ServerMessageInputHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //处理当前客户端的发送过来的message
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

            while (true) {
                //读取一行数据
                Message message = (Message) ois.readObject();
                System.out.println(message);
                if (message.getReceiver().equals("all")) {

                    String content = message.getContent();

                    Set<String> ips = ChatServer.clients.keySet();

                    for (String ip :
                            ips) {
                        Socket socket = ChatServer.clients.get(ip);
                        //得到接收者的输出流
                        OutputStream outputStream = socket.getOutputStream();

                        //用于将对象发送出去
                        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

                        oos.writeObject(message);
                    }

                } else {


                    //获取接收者与服务端之间的连接
                    Socket receiverSocket = ChatServer.clients.get(message.getReceiver());
                    if (receiverSocket == null) {
                        System.out.println("ip不存在");
                        continue;
                    }
                    //得到接收者的输出流
                    OutputStream outputStream = receiverSocket.getOutputStream();
                    //使用对象流输出
                    //用于将对象发送出去
                    ObjectOutputStream oos = new ObjectOutputStream(outputStream);

                    oos.writeObject(message);
                }

            }
            //

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
