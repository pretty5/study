package chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/*
*@ClassName:ChatServer
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:48 
 @Version:v1.0
*/
//聊天服务器
public class ChatServer {

    public static Map<String,Socket> clients=new HashMap<>();
    //服务端监听的端口号
    private int port;

    public ChatServer(int port) {
            this.port=port;
    }

    public static void main(String[] args) {
        new ChatServer(9999).start();
    }

    private void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            //不断接收来自客户端的连接
            while (true){
                Socket client = serverSocket.accept();
                //得到客户端的ip
                String clientIp = client.getInetAddress().getHostAddress();
                System.out.println(clientIp);
                //将客户端信息保存
                clients.put(clientIp,client);
                //创建一个新的线程来服务于连接的客户端
                new Thread(new ClientHandler(client)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
