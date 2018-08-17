package servlet;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/*
*@ClassName:LoginCookieServlet
 @Description:TODO
 @Author:
 @Date:2018/8/16 16:32 
 @Version:v1.0
*/
//使用cookie
public class LoginCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ///HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                if (name.equals("user")) {
                    resp.getWriter().println("already login");
                    return;
                }
            }
        }
        //super.doPost(req, resp);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //校验
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            resp.getWriter().println("failure");
            return;
        }
        if (name.equals("zhangsan") && password.equals("123")) {
            //将登陆信息放入cookie
            Cookie cookie = new Cookie("user", name);
            //设置cookie的有效期
            cookie.setMaxAge(3600*24*7);
            resp.addCookie(cookie);

            resp.getWriter().println("login success");
        } else {
            resp.getWriter().println("failure");
        }
    }
}
