package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
*@ClassName:ProxyHandler
 @Description:TODO
 @Author:
 @Date:2018/8/7 10:56 
 @Version:v1.0
*/
/*
    InvocationHandler:在其中实现代理逻辑

 */
public class ProxyHandler implements InvocationHandler {
    //被代理类。
    private Fly proxied;

    public ProxyHandler(Fly proxied) {
        this.proxied = proxied;
    }

    //当调用被代理类的方法时，会进入invoke方法
    //如被代理类是bird，方法是fly
    //proxy：表示的是代理类
    //Method：表示的被调用方法
    //args：表示方法参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("i can sing");
        method.invoke(this.proxied,args);//
        System.out.println("i can dance");
        return null;
    }
}
