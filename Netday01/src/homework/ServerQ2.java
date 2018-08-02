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
public class ServerQ2 {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(888);
        Socket client = serverSocket.accept();
        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();
        byte[] buffer =new byte[1024];
        int length = inputStream.read(buffer);
        String content = new String(buffer, 0, length);
        System.out.println(content);
        String[] nums = content.split(",");
        //Integer.valueOf Integer.parseInt 将字符串转换成数字
        int sum=Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
        //String.valueof 将其他类型的数据转换成字符串
        outputStream.write(String.valueOf(sum).getBytes());
        inputStream.close();
        outputStream.close();
        client.close();
    }
}
