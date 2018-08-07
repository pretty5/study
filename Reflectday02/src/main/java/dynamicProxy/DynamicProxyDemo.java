package dynamicProxy;

import java.lang.reflect.Proxy;

/*
*@ClassName:DynamicProxyDemo
 @Description:TODO
 @Author:
 @Date:2018/8/7 10:49 
 @Version:v1.0
*/
/*
    动态代理测试：动态生成代理类。
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        //生成代理实例
        //获取类加载器
        ClassLoader classLoader = Fly.class.getClassLoader();
        //被代理类的接口
        Class[] interfaces = {Fly.class};
        //代理处理类
        ProxyHandler proxyHandler = new ProxyHandler(new Pig());
        //生成真正的代理类
        Fly pigProxy = (Fly) Proxy.newProxyInstance(classLoader, interfaces, proxyHandler);
        pigProxy.fly();
        pigProxy.eat();

        ProxyHandler proxyHandler2 = new ProxyHandler(new Bird());
        Fly birdProxy = (Fly) Proxy.newProxyInstance(classLoader, interfaces, proxyHandler2);
        birdProxy.fly();

        ProxyHandler proxyHandler3 = new ProxyHandler(new Dog());
        Fly dogProxy = (Fly) Proxy.newProxyInstance(classLoader, interfaces, proxyHandler3);
        dogProxy.fly();



    }
}
