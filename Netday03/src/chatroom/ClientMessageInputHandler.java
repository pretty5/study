package chatroom;

import java.io.IOException;
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
    private ChatClient client;
    public ClientMessageInputHandler(ChatClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {

            while (true) {
               Message message= (Message) client.getOis().readObject();
               System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
