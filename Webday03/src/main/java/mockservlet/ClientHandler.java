package mockservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/*
*@ClassName:ClientHandler
 @Description:TODO
 @Author:
 @Date:2018/8/15 14:46
 @Version:v1.0
*/
public class ClientHandler implements Runnable {
    //表示客户端链接
    private  Socket client;

    public ClientHandler(Socket client) {
        this.client=client;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = client.getInputStream();
            byte[] buffer=new byte[1024*1024*10];
            int len = inputStream.read(buffer);
            //请求字符串
            String requestString = new String(buffer, 0, len+1);
            //System.out.println(requestString);
            //拿出第一行  第一行是请求行 包含方法 请求路径
            String[] lines = requestString.split("\n");
            //第一行的第一个单词是请求方法
            String methodName = lines[0].split(" ")[0];
            //第一行的第二个单元式请求路径
            String requestPath = lines[0].split(" ")[1];
            if (methodName.equals("GET")){
                //获得请求参数
                String queryString = requestPath.substring(requestPath.indexOf("?") + 1);
                //获取请求的url
                String url = requestPath.substring(0, requestPath.indexOf("?"));
                //获取处理该请求的servletName
                String servletName = ServletServer.urlToServletName.get(url);
                //获取该servletName对应的servletClass
                String servletClass = ServletServer.servletNameToServletClass.get(servletName);
                //懒加载 需要的时候才去创建servlet对象
                if (ServletServer.classToObject.get(servletClass)==null){
                    //通过反射机制创建
                    HttpServlet servlet = (HttpServlet) Class.forName(servletClass).newInstance();
                    //创建完后存起来
                    ServletServer.classToObject.put(servletClass,servlet);
                }
                HttpServlet servlet = ServletServer.classToObject.get(servletClass);

                ZhiyouHttpServletRequest request = new ZhiyouHttpServletRequest();
                 //解析请求字符串 转换成map
                Map<String,String> params=parseQueryString(queryString);
                request.setParams(params);
                //封装响应
                ZhiyouHttpServletResponse response = new ZhiyouHttpServletResponse(client);
                //调用service方法 实现请求响应
                servlet.service(request,response);

            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> parseQueryString(String queryString) {
        Map<String, String> params = new HashMap<>();
        //拆分字符串  name=123&password=456
        String[] kvs = queryString.split("&");
        //按照=拆出key和value
        for (int i = 0; i < kvs.length; i++) {
            String[] kv = kvs[i].split("=");
            params.put(kv[0],kv[1]);
        }
        return params;
    }
}
