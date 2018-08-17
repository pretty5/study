package servlet;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
*@ClassName:LoginServlet
 @Description:TODO
 @Author:
 @Date:2018/8/16 15:07 
 @Version:v1.0
*/
//用来处理登陆请求：如果session没有客户端的信息，要要求登陆，如果有，则放行
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断用户以前是否登陆过
        HttpSession session = req.getSession();

        String user = (String) session.getAttribute("user");
        if (user!=null){
            resp.getWriter().println("already login");
            return;
        }
        //super.doPost(req, resp);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //校验
        if (StringUtils.isEmpty(name)||StringUtils.isEmpty(password)){
            resp.getWriter().println("failure");
            return;
        }
        if (name.equals("zhangsan")&&password.equals("123")){
            //将登陆信息放入session
            session.setAttribute("user","zhangsan");
            resp.getWriter().println("login success");
        }else{
            resp.getWriter().println("failure");
        }


    }
}
