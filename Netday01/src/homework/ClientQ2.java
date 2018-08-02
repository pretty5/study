package homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
*@ClassName:ClientQ1
 @Description:TODO
 @Author:
 @Date:2018/8/1 9:02 
 @Version:v1.0
*/
public class ClientQ2 {
    public void start() throws IOException {

        Socket socket = new Socket("127.0.0.1", 888);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
       /* Scanner scanner = new Scanner(System.in);
        String nums = scanner.next();*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nums = reader.readLine();
        //String num2 = scanner.next();
        outputStream.write(nums.getBytes());
        byte[] buffer =new byte[1024];
        int length = inputStream.read(buffer);
        System.out.println(new String(buffer,0,length));

        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
