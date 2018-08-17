package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
*@ClassName:LogoutServlet
 @Description:TODO
 @Author:
 @Date:2018/8/16 16:05 
 @Version:v1.0
*/
//退出登陆
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user==null){
            resp.getWriter().println("please login");
            return;
        }
        //删除登陆信息
        session.removeAttribute("user");
        resp.getWriter().println("logout");
    }
}
