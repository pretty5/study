package homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
*@ClassName:ClientQ1
 @Description:TODO
 @Author:
 @Date:2018/8/7 9:09 
 @Version:v1.0
*/
public class ClientQ2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        //客户端发送请求
        Request request = new Request();
        request.setMethodName("addx");
        request.setParams(new Object[]{1,2,3});
        //将对象发送出去 使用对象流
        oos.writeObject(request);
        Response response = (Response) ois.readObject();
        System.out.println(response);
    }
}
