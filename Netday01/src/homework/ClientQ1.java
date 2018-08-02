package homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
*@ClassName:ClientQ1
 @Description:TODO
 @Author:
 @Date:2018/8/1 9:02 
 @Version:v1.0
*/
public class ClientQ1 {
    public void start() throws IOException {

        Socket socket = new Socket("127.0.0.1", 888);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        byte[] buffer =new byte[1024];
        int length = inputStream.read(buffer);
        System.out.println(new String(buffer,0,length));

        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
