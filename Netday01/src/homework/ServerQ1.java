package homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
*@ClassName:ServerQ1
 @Description:TODO
 @Author:
 @Date:2018/8/1 9:07 
 @Version:v1.0
*/
public class ServerQ1 {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(888);
        Socket client = serverSocket.accept();
        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();
        byte[] buffer =new byte[1024];
        int length = inputStream.read(buffer);
        System.out.println(new String(buffer,0,length));
        outputStream.write("hello,too!".getBytes());
        inputStream.close();
        outputStream.close();
        client.close();
    }
}
