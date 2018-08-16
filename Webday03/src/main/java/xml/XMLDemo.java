package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XMLDemo {

    public static void main(String[] args) throws DocumentException {
        readTest();
    }
    //测试读取xml文件
    private static void readTest() throws DocumentException {
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

        }
        List mappings = rootElement.elements("servlet-mapping");
        //遍历mappings
        for (int i = 0; i < mappings.size(); i++) {
            Element mapping = (Element) mappings.get(i);
            //getText获取标签中的值
            String servletName = mapping.element("servlet-name").getText();
            String urlPattern = mapping.element("url-pattern").getText();
            //将配置文件的关系放入缓存中

        }
    }
}
