package chatroom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Set;

/*
*@ClassName:ServerInputHandler
 @Description:TODO
 @Author:
 @Date:2018/8/1 14:19
 @Version:v1.0
*/
//服务端用来处理客户端输入线程
public class ServerMessageInputHandler implements Runnable {

    private Socket client;

    public ServerMessageInputHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //处理当前客户端的发送过来的message
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

            while (true) {
                //读取一行数据
                Message message = (Message) ois.readObject();
                System.out.println(message);
                //处理登陆
                if (message.getType()==0){
                    //检查客户端的登陆信息
                    Message response=checkLogin(message);
                    //响应发送出去
                    ChatServer.objectOutputStreams.get(message.getSender()).writeObject(response);

                    continue;
                }
                //处理list
                if (message.getType()==3){
                    Message response = new Message();
                    response.setContent(ChatServer.clients.keySet().toString());
                    //响应发送出去
                    ChatServer.objectOutputStreams.get(message.getSender()).writeObject(response);
                    continue;
                }
                //处理exit
                if (message.getType()==2){
                    System.out.println(message.getSender()+"下线了");
                    ChatServer.clients.remove(message.getSender());
                    ChatServer.objectOutputStreams.remove(message.getSender());
                    continue;
                }
                if (message.getReceiver().equals("all")) {
                    Set<String> ips = ChatServer.objectOutputStreams.keySet();
                    for (String ip :
                            ips) {
                        //根据ip得到对象输出流
                        ObjectOutputStream oos = ChatServer.objectOutputStreams.get(ip);
                        //将对象发送除去
                        oos.writeObject(message);
                    }

                } else {
                    //获取接收者与服务端之间的连接
                    ObjectOutputStream oos = ChatServer.objectOutputStreams.get(message.getReceiver());
                    if (oos == null) {
                        System.out.println("此ip未上线");
                        continue;
                    }
                    oos.writeObject(message);
                }

            }
            //

        } catch (Exception e) {

            try {
                //清除缓存
                ChatServer.clients.remove(client.getInetAddress().getHostAddress());
                ChatServer.objectOutputStreams.remove(client.getInetAddress().getHostAddress());
                //关闭资源
                client.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }


            //e.printStackTrace();
        }
    }
    //校验登陆
    private Message checkLogin(Message message) throws IOException {
        //加载密码文件
        Properties prop = new Properties();
        prop.load(ServerMessageInputHandler.class.getClassLoader().getResourceAsStream("password"));
        Message response = new Message();
        //判断客户端发送过来的密码与服务端存储的密码是否一致

        if ((prop.getProperty(message.getSender()))==null){
            response.setContent("success");
        }
        if(prop.getProperty(message.getSender()).equals(message.getContent())){
            response.setContent("success");
        }else{
            response.setContent("success");
        }
        return response;
    }
}
