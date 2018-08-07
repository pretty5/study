package homework;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
*@ClassName:ClientQ1
 @Description:TODO
 @Author:
 @Date:2018/8/7 9:09 
 @Version:v1.0
*/
public class ClientQ1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 999);

        //IOUtils.write("add,1,1",socket.getOutputStream());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("mul,1,1".getBytes());
        byte[] buffer=new byte[1024];
        int len = socket.getInputStream().read(buffer, 0, 1024);
        System.out.println(new String(buffer,0,len));

    }
}
