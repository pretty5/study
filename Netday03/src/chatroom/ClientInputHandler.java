package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
*@ClassName:ServerInputHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:19
 @Version:v1.0
*/
public class ClientInputHandler implements Runnable {
    private Socket client;

    public ClientInputHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //处理当前客户端的输入信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true) {
                //读取一行数据
                String line = reader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
