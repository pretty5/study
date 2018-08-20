package homework;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/*
*@ClassName:FreePasswordServlet
 @Description:TODO
 @Author:
 @Date:2018/8/17 9:43 
 @Version:v1.0
*/
public class FreePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断用户以前是否登陆过
        HttpSession session = req.getSession();

        String user = (String) session.getAttribute("user");
        if (user != null) {
            updateCookie(resp);
            resp.getWriter().println("already login");
            return;
        }
        //如果session没有登陆信息，则看cookie的信息是否在有效期内
        //如果在有效期 则登陆  同时刷新有效期时间
        if (user == null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if (name.equals("user")) {
                        //新建cookie将原来cookie覆盖掉
                        updateCookie(resp);
                        session.setAttribute("user", "zhangsan");
                        resp.getWriter().println("login success");
                        return;
                    }
                }
            }
        }

        //否则不能登陆 使用用户名和密码登陆
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //校验
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            resp.getWriter().println("failure");
            return;
        }
        if (name.equals("zhangsan") && password.equals("123")) {
            //将登陆信息放入session
            session.setAttribute("user", "zhangsan");
            updateCookie(resp);
            resp.getWriter().println("login success");
        } else {
            resp.getWriter().println("failure");
        }

    }

    private void updateCookie(HttpServletResponse resp) {
        Cookie newCookie = new Cookie("user", "zhangsan");
        newCookie.setMaxAge(7 * 24 * 3600);
        resp.addCookie(newCookie);
    }
}
