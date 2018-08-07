package homework;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/*
*@ClassName:ServerQ1
 @Description:TODO
 @Author:
 @Date:2018/8/7 9:03 
 @Version:v1.0
*/
public class ServerQ1 {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ServerSocket serverSocket = new ServerSocket(999);
        Socket client = serverSocket.accept();

        //String content = IOUtils.toString(client.getInputStream());
       // System.out.println(content);
        InputStream inputStream = client.getInputStream();

        byte[] buffer=new byte[1024];
        int len=0;
        len=inputStream.read(buffer);
        String content = new String(buffer, 0, len);
        //切割字符串
        String[] strings = content.split(",");

        String methodName = strings[0];
        String p1 = strings[1];
        String p2 = strings[2];

        Class<CalculatorImpl> clazz = CalculatorImpl.class;
        Method method = clazz.getMethod(methodName, int.class, int.class);
        //调用方法
        Integer res = (Integer) method.invoke(new CalculatorImpl(), Integer.parseInt(p1), Integer.parseInt(p2));
        //System.out.println(res);
        client.getOutputStream().write(String.valueOf(res).getBytes());


    }
}
