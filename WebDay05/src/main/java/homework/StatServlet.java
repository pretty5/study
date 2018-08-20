package homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
*@ClassName:StatServlet
 @Description:TODO
 @Author:
 @Date:2018/8/17 9:09 
 @Version:v1.0
*/
public class StatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //每次查看  查看session中保存的计数，无则添加 ，有则加1
        HttpSession session = req.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count==null){
            //没有 则初始化为1
            count=1;
        }else{
            count++;
        }
        session.setAttribute("count",count);

        resp.getWriter().println("count: "+count);
    }
}
