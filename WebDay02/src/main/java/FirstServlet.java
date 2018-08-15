import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
* HttpServlet是一个用于处理http请求的servlet
* 如果客户端不用上传数据 ，则用get
* 如果上传参数
*
* */
public class FirstServlet extends HttpServlet {
    //专门用来处理get请求的方法
    //一个请求如果不声明的话，默认get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //给客户端输出hello world
        resp.getWriter().println("hello world");

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
       // super.init(config);
        System.out.println("init");
    }

    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("init");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.getWriter().println("hello world post invoked");
    }
}
