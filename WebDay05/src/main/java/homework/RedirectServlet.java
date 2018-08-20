package homework;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*@ClassName:RedirectServlet
 @Description:TODO
 @Author:
 @Date:2018/8/17 10:52 
 @Version:v1.0
*/
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //客户端地址会变化  客户端会再次请求 客户端请求重定向
        resp.sendRedirect("stat/user");
        //客户端地址不会变化  客户端只有一次请求 服务器请求转发
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("stat/user");
        //requestDispatcher.forward(req,resp);
        //super.doGet(req, resp);
    }
}
