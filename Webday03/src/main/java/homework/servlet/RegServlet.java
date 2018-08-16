package homework.servlet;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/*
*@ClassName:RegServlet
 @Description:TODO
 @Author:
 @Date:2018/8/15 10:10 
 @Version:v1.0
*/
//处理注册请求
public class RegServlet extends HttpServlet {
    private static final Logger log=LoggerFactory.getLogger(RegServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //拿到客户端上传的用户名和密码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //避免中文乱码
        resp.setContentType("text/html;charset=UTF-8");
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
            resp.getWriter().println("注册成功");
        } catch (Exception e) {
            log.error("error:{}",e);
            resp.getWriter().println("注册不成功");
        }

    }
}
