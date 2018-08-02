package chatroom;



import java.io.IOException;
import java.net.Socket;

/*
*@ClassName:Client
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:12 
 @Version:v1.0
*/
//读写分离的客户端
public class ChatClient {
    private String ip;
    private int port;

    public ChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        //创建一个客户端 之后启动
        new ChatClient("192.168.40.92", 9999).start();

    }

    private void start() throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("i am client");
        new Thread(new ClientMessageInputHandler(socket)).start();
        new Thread(new ClientMessageOutputHandler(socket)).start();
    }

}
