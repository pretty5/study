package mockservlet;

/*
*@ClassName:ServletServer
 @Description:TODO
 @Author:
 @Date:2018/8/15 14:42 
 @Version:v1.0
*/


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//接收http请求，将请求转发给servlet处理。
public class ServletServer {
    //url跟servlet之间映射关系
    public static Map<String,String> urlToServletName=new HashMap<>();
    //servletName和servletClass之间映射关系
    public static Map<String,String> servletNameToServletClass=new HashMap<>();
    //servletClass与它的实例之间的映射关系
    //Collections.synchronizedMap 对map加锁 保证线程安全
    public static Map<String,HttpServlet> classToObject=Collections.synchronizedMap(new HashMap<String,HttpServlet>());

    public static void main(String[] args) throws IOException, DocumentException {
        ServerSocket serverSocket = new ServerSocket(80);
        //服务端初始化 模拟tomcat加载web.xml
        init();

        while (true){
            Socket client = serverSocket.accept();
            //每一个链接创建一个线程来处理
            new Thread(new ClientHandler(client)).start();
        }

    }

    private static void init() throws DocumentException {
        String path = "Webday03/target/Webday03/WEB-INF/web.xml";
        //sax=simple api for xml
        SAXReader reader = new SAXReader();
        //读取xml文件返一个document 对象
        Document document = reader.read(path);
        //获取文档的根部元素
        Element rootElement = document.getRootElement();
        //根元素的名字
        String name = rootElement.getName();
        // System.out.println(name);
        //获取根元素的子元素
        List servlets = rootElement.elements("servlet");
        //遍历servlets
        for (int i = 0; i < servlets.size(); i++) {
            Element servlet = (Element) servlets.get(i);
            //getText获取标签中的值
            String servletName = servlet.element("servlet-name").getText();
            String servletClass = servlet.element("servlet-class").getText();
            System.out.println("name: " + servletName + " class: " + servletClass);
            //将配置文件的关系放入缓存中
            servletNameToServletClass.put(servletName,servletClass);
        }
        List mappings = rootElement.elements("servlet-mapping");
        //遍历mappings
        for (int i = 0; i < mappings.size(); i++) {
            Element mapping = (Element) mappings.get(i);
            //getText获取标签中的值
            String servletName = mapping.element("servlet-name").getText();
            String urlPattern = mapping.element("url-pattern").getText();
            //将配置文件的关系放入缓存中
            urlToServletName.put(urlPattern,servletName);
        }
    }
}
