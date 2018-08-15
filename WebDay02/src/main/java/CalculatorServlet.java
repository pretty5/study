import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class CalculatorServlet extends HttpServlet {
    //获取日志对象
    private  static Logger LOG =LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
       // testReq(req);
        testLog(req);

    }

    private void testLog(HttpServletRequest req) {
        LOG.info("method {}",req.getMethod());
    }

    private void testReq(HttpServletRequest req) {
        //获取路径信息
        String pathInfo = req.getPathInfo();
        System.out.println("pathinfo: "+pathInfo);
        //获取请求的方法
        String method = req.getMethod();
        System.out.println("method: "+method);
        //获取应用路径
        String contextPath = req.getContextPath();
        System.out.println("contextPath: "+contextPath);
        //获取请求头信息
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            Object key = headerNames.nextElement();
            System.out.println(key+":"+req.getHeader((String) key));
        }
        //获取查询字符串
        String queryString = req.getQueryString();
        System.out.println("querystring: "+queryString);
        //获取请求用户的ip
        String remoteUser = req.getRemoteAddr();
        System.out.println("remoteUser:"+remoteUser);
        //获取请求路径
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL: "+requestURL);
        //根据请求的key  获取其对应的多个值
        String[] values = req.getParameterValues("abc");
        System.out.println(Arrays.toString(values));
        //根据请求的key  获取一个值
        String value = req.getParameter("abc");
        System.out.println("value: "+value);
        //获取所有请求参数
        Map parameterMap = req.getParameterMap();
        String[] value2 = (String[]) parameterMap.get("abc");
        System.out.println(Arrays.toString(value2));
    }
}
