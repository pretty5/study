package nets;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
*@ClassName:Client
 @Description:TODO
 @Author:
 @Date:2018/7/31 16:54 
 @Version:v1.0
*/
public class Client {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 2000; i++) {
            new Client().start();
        }

    }
    public void start() throws IOException {
        //创建一个和服务端的连接
        //127.0.0.1本机地址
        //端口号范围在0-65535 2的16次方-1。
        System.out.println("ready to connect server");
        Socket socket = new Socket("192.168.40.112", 999);
        System.out.println("connect to server");
        //获取输出流，通过此流可以往服务端发送数据。
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.close();
        //关闭与服务端的连接
        socket.close();

    }
}
