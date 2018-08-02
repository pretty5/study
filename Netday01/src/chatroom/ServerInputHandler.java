package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/*
*@ClassName:ServerInputHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:19
 @Version:v1.0
*/
//服务端用来处理客户端输入线程
public class ServerInputHandler implements Runnable {
    private Socket client;

    public ServerInputHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //处理当前客户端的输入信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true) {
                //读取一行数据
                String line = reader.readLine();
                if (line.startsWith("@")){
                    if (line.startsWith("@all")){
                        //广播  暂时先不处理
                    }else{
                        //获取ip和要发送的内容
                        //@192.168.40.2:hello
                        String[] strings = line.split(":");
                        //接收者的ip
                        String receiverIp=strings[0].substring(1);
                        //要发送的内容
                        String content=strings[1];
                        //获取接收者与服务端之间的连接
                        Socket receiverSocket = ChatServer.clients.get(receiverIp);
                        if (receiverSocket==null){
                            System.out.println("ip不存在");
                            continue;
                        }
                        //得到接收者的输出流
                        OutputStream outputStream = receiverSocket.getOutputStream();

                        outputStream.write((content+"\n").getBytes());
                    }

                }
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
