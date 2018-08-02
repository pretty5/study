package homework;

import java.io.*;
import java.net.Socket;

/*
*@ClassName:ClientQ1
 @Description:TODO
 @Author:
 @Date:2018/8/1 9:02 
 @Version:v1.0
*/
public class ClientQ3 {
    /*boolean close= false;

    public void close(){
        close=true;
    }*/
    public void stop(Socket socket) throws IOException {
        socket.getInputStream().close();
        socket.getOutputStream().close();
        socket.close();

    }
    public void start() throws IOException {


        Socket socket = new Socket("127.0.0.1", 888);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();


       for(;;){
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String line = reader.readLine();
           line="client: "+line;
           if (line.equals("close")){
               stop(socket);
               //关闭虚拟机，退出进程
               System.exit(0);
           }
           /*if (close){
               stop(socket);
               System.exit(0);
           }*/
           outputStream.write(line.getBytes());
           byte[] buffer =new byte[1024];
           int length = inputStream.read(buffer);
           String content = new String(buffer, 0, length);
           System.out.println(content);

       }




    }
}
