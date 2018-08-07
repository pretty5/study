package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
*@ClassName:WebServer
 @Description:TODO
 @Author:
 @Date:2018/8/2 17:09 
 @Version:v1.0
*/
//一个最简单的web服务器
public class WebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        Socket client = serverSocket.accept();
        //得到客户端的输入流
        InputStream inputStream = client.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (true){
            String line=reader.readLine();
            if (line==null){
                break;
            }
            System.out.println(line);
        }
        reader.close();
    }

}
