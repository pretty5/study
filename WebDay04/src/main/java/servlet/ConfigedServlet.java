package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*@ClassName:ConfigedServlet
 @Description:TODO
 @Author:
 @Date:2018/8/16 14:08 
 @Version:v1.0
*/
public class ConfigedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servletConfig配置对象 相当于获取在web.xml中配置的初始化参数
        ServletConfig servletConfig = getServletConfig();
        //根据配置参数名称  获取参数值
        String respCharset = servletConfig.getInitParameter("respCharset");
        String reqCharset = servletConfig.getInitParameter("reqCharset");

        System.out.println(reqCharset);

        //req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String characterEncoding = req.getCharacterEncoding();
        System.out.println(characterEncoding);
        resp.setContentType(respCharset);
        String key = req.getParameter("name");
        //System.out.println(new String(key.getBytes("ISO-8859-1"), "UTF-8"));
        System.out.println(key);
        resp.getWriter().println("雷好");

    }
}
