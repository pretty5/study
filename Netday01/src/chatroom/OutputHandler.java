package chatroom;

import java.io.*;
import java.net.Socket;

/*
*@ClassName:OutputHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:24
 @Version:v1.0
*/
//用来处理输出的线程
public class OutputHandler implements Runnable {
    private Socket client;

    public OutputHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //往客户端的输出流
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            //来自键盘的输入流
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                //读取输入的一行数据
                String line = keyBoard.readLine();
                //将输入的数据  输出到网络（客户端）
                writer.println(line);
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
