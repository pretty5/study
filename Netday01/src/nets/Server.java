package nets;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
*@ClassName:Server
 @Description:TODO
 @Author:
 @Date:2018/7/31 16:54 
 @Version:v1.0
*/
public class Server {
    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        //在本机打开999端口，监听来自网络的连接
        ServerSocket serverSocket = new ServerSocket(999);
        //阻塞等待直到有客户端连接，返回此客户端（服务端与客户端之间的连接）。
        while (true) {
            System.out.println("ready to accept");
            Socket client = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("a client connect");
                        System.out.println(client.getInetAddress().getHostAddress());
                        //通过输入流获取客户端发送过来的数据
                        InputStream inputStream = null;
                        inputStream = client.getInputStream();
                        byte[] buffer = new byte[200];
                        inputStream.read(buffer);
                        System.out.println(new String(buffer));
                        //关闭流
                        //inputStream.close();
                        //关闭客户端连接
                        //client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

            //关闭监听的端口
            //serverSocket.close();
        }


    }
}
