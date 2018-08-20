package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
*@ClassName:RequestHandler
 @Description:TODO
 @Author:
 @Date:2018/8/20 17:34 
 @Version:v1.0
*/
/*
 对 类和方法的封装
 */
public class RequestHandler {
    //类名
    private String className;//logincontroller
    //方法名
    private String methodName;//login

    public RequestHandler(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    //用来处理请求的方法
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(clazz.newInstance(),request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
