package mockservlet;

import homework.servlet.JDBCUtil;
import homework.servlet.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*@ClassName:RegServlet
 @Description:TODO
 @Author:
 @Date:2018/8/15 10:10 
 @Version:v1.0
*/
//处理注册请求
public class ZhiyouRegServlet extends HttpServlet {
    private static final Logger log=LoggerFactory.getLogger(ZhiyouRegServlet.class);

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        doPost((HttpServletRequest) req, (HttpServletResponse) res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //拿到客户端上传的用户名和密码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //避免中文乱码
        //resp.setContentType("text/html;charset=UTF-8");
        //校验
        if (StringUtils.isEmpty(name)||StringUtils.isEmpty(password)){
            resp.getWriter().println("用户名或密码错误");
            return;
        }
        //校验成功 保存数据库
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        try {
            JDBCUtil.insert(user);
            String response="HTTP/1.1 200 OK\n" +
                    "Server: Tengine\n" +
                    "Content-Type: text/html\n" +
                    "Content-Length: 100\n" +
                    "Connection: keep-alive\n" +
                    "Date: Sat, 11 Aug 2018 13:19:00 GMT\n" +
                    "X-Powered-By: HHVM/3.22.1\n" +
                    //"Content-Encoding: gzip\n" +
                    "Vary: Accept-Encoding\n" +
                    "Via: cache19.l2et15-2[0,200-0,H], cache23.l2et15-2[1,0], kunlun10.cn1418[0,200-0,H], kunlun10.cn1418[1,0]\n" +
                    "Age: 138656\n" +
                    "X-Cache: HIT TCP_MEM_HIT dirn:0:226396307 mlen:-1\n" +
                    "X-Swift-SaveTime: Sun, 12 Aug 2018 06:43:26 GMT\n" +
                    "X-Swift-CacheTime: 86400\n" +
                    "Timing-Allow-Origin: *\n" +
                    "EagleId: df6fef1e15341321960398755e\n" +
                    "\n"+
                    "<p> <font size=\"20\" color=\"red\">regist success</font></p>";
            resp.getWriter().println(response);
            //resp.getWriter().println("注册成功");
        } catch (Exception e) {
            log.error("error:{}",e);
            resp.getWriter().println("注册不成功");
        }

    }
}
