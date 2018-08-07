package homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/*
*@ClassName:ClientQ1
 @Description:TODO
 @Author:
 @Date:2018/8/7 9:09 
 @Version:v1.0
*/
//rpc  remote process call 远程方法调用
//像调用本地方法一样调用远程方法，中间的网络通信，序列化，反射对客户端来说都是透明的。
public class ClientQ2Plus {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 999);
        final ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        final ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        //生成代理类
        //类加载器
        ClassLoader classLoader = CalculatorImpl.class.getClassLoader();
        //接口
        Class[] interfaces = {Calculator.class};
        //代理处理类
        InvocationHandler invocationHandler = new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String name = method.getName();
                Request request = new Request();
                request.setMethodName(name);
                request.setParams(args);
                //发送出去
                oos.writeObject(request);
                //接收结果
                Response response = (Response) ois.readObject();

                System.out.println(response);

                return response.getResult();
            }
        };
        //生成一个代理对象
        Calculator cal = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        int res = cal.addx(1,1,1);

        System.out.println(res);



    }
}
