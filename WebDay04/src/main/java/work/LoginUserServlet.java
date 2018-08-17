package work;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        int c =1;
        HttpSession session = req.getSession();

        String user = (String) session.getAttribute("user");
        if (user!=null){
           Integer count = (Integer) session.getValue("count");
            count=count+1;
            session.removeAttribute("count");
            session.setAttribute("count",count);
            resp.getWriter().println("already login  "+count);
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
            session.setAttribute("count",c);
            resp.getWriter().println("login success  "+c);
        }else{
            resp.getWriter().println("failure");
        }


    }
}
