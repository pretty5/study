package chatroom;

import java.io.*;
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
    //客户端与服务端的连接
    private Socket socket;
    //客户端的对象输出流
    private ObjectOutputStream oos;
    //客户端的对象输入流
    private ObjectInputStream ois;
    //客户端的名字
    private String name;



    public ChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        //创建一个客户端 之后启动
        new ChatClient("127.0.0.1", 9999).start();

    }

    private void start() throws IOException {
        //初始化
        init();
        //登陆
        doLogin();
        new Thread(new ClientMessageInputHandler(this)).start();
        new Thread(new ClientMessageOutputHandler(this)).start();
    }

    //客户端初始化
    private void init() {
        Socket socket = null;
        try {
            socket = new Socket(ip, port);
            this.socket = socket;
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("i am client");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }
    //登陆
    private void doLogin() {
        while (true) {
            //读取键盘输入，
            System.out.println("please input password: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                //收到用户输入的密码
                String password = reader.readLine();
                Message message = new Message();
                //设置发送方ip
                message.setSender(socket.getLocalAddress().getHostAddress());
                message.setContent(password);
                message.setType(0);
                //发送
                this.oos.writeObject(message);
                //接收服务端的响应
                Message response = (Message) this.ois.readObject();
                if (response.getContent().equals("failure")) {
                    System.out.println("密码错误，请重新输入");
                    continue;
                }else{
                    System.out.println("登陆成功");
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
