package homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
/*
`   使用面向对象（request,response）封装以后,
    可以不用在服务端写死参数类型，
    也可以不用在限定方法的参数个数。
 */
public class ServerQ2 {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(999);
        Socket client = serverSocket.accept();
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        //接收来自客户端发送过来request对象
        Request request = (Request) ois.readObject();
        //取出参数和方法名
        String methodName = request.getMethodName();
        Object[] params = request.getParams();

        Class<CalculatorImpl> clazz = CalculatorImpl.class;
        //clazz.getMethod(methodName,)
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method :
                methods) {
            if (method.getName().equals(methodName)){
                //int add = new CalculatorImpl().add(1, 1);
                Object res = method.invoke(new CalculatorImpl(), params);
                //生成响应
                Response response = new Response();
                response.setResult(res);
                response.setMsg("success");
                //输出响应
                oos.writeObject(response);
            }
        }

    }
}
