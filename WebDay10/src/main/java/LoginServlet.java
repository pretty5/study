import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*@ClassName:LoginServlet
 @Description:TODO
 @Author:
 @Date:2018/8/24 15:09 
 @Version:v1.0
*/
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       resp.getWriter().println("{\"message\":\"ok\"}");
       //super.doPost(req, resp);
    }
}
