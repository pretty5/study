package chatroom;

import java.net.Socket;

/*
*@ClassName:ClientHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:55
 @Version:v1.0
*/
public class ClientHandler implements Runnable {
    //客户端连接
    private Socket client;

    public ClientHandler(Socket client) {
        this.client=client;
    }

    @Override
    public void run() {
        //启动读线程来处理读
        new Thread(new ServerMessageInputHandler(client)).start();
        //启动写线程来处理写
        new Thread(new OutputHandler(client)).start();

    }
}
