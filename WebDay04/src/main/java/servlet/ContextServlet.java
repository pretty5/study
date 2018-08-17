package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*@ClassName:ContextServlet
 @Description:TODO
 @Author:
 @Date:2018/8/16 14:49 
 @Version:v1.0
*/
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取全局配置
        ServletContext servletContext = getServletContext();
        String key = servletContext.getInitParameter("key");
        String key2 = servletContext.getInitParameter("key2");

        System.out.println(key);
        System.out.println(key2);
    }
}
