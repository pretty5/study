package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

/*
*@ClassName:ServerInputHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:19
 @Version:v1.0
*/
public class ClientMessageInputHandler implements Runnable {
    private Socket client;

    public ClientMessageInputHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            while (true) {
               Message message= (Message) ois.readObject();
               System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
