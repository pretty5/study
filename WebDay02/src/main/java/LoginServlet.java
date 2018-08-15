import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //因为登录涉及到登录密码，不宜在地址栏显示，使用post发送请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name.equals("abc") && password.equals("123")){
            System.out.println("login success");
            resp.getWriter().println("login success");
        }else {
            resp.getWriter().println("用户名密码错误");
        }

    }
}
