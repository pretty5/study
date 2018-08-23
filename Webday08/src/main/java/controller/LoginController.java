package controller;

import annotition.Bean;
import annotition.MethodType;
import annotition.RequestMapping;
import annotition.Require;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:LoginController
 @Description:TODO
 @Author:
 @Date:2018/8/20 16:45 
 @Version:v1.0
*/
@Bean
@RequestMapping("/login")
public class LoginController {
    @Require
    UserService userService;

    @MethodType("post")
    @RequestMapping("/sqlInjectLogin.do")
    public void sqlInjectlogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        //response.getWriter().println("to login");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sql = "select * from user where name= '" + name + "' and password ='" + password + "'";
        // String sql="select * from user where name = ? and password = ?";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456");
        //执行查询
        QueryRunner queryRunner = new QueryRunner();
        List<User> userList = queryRunner.query(connection, sql, new BeanListHandler<User>(User.class));
        if (userList.size() > 0) {
            response.getWriter().println("login success");
        } else {
            response.getWriter().println("login failure");
        }


    }

    /*@RequestMapping("/login0")
    public void login0(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.getWriter().println("to logout");
        String name = request.getParameter("name");
        String password=request.getParameter("password");
        try {
            List<User> users = DBUtil.queryByConditions("select * from user where name=? and password =?", User.class, name, password);
            if (users.size()>0){
                response.getWriter().println("login success");
            }else{
                response.getWriter().println("login failure");
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            response.getWriter().println("login failure");
        }
    }
    @RequestMapping("/login1")
    public void login1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.getWriter().println("to logout");
        String name = request.getParameter("name");
        String password=request.getParameter("password");
        try {
            UserDao userDao = new UserDao();
            List<User> users = userDao.queryByNameAndPassword(name, password);
            if (users.size()>0){
                response.getWriter().println("login success");
            }else{
                response.getWriter().println("login failure");
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            response.getWriter().println("login failure");
        }
    }
*/
    @RequestMapping("/login2.do")
    public void login2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");


        UserService userService = new UserService();
        boolean login = userService.login(name, password);


        if (login) {
            response.getWriter().println("success");
        } else {
            response.getWriter().println("failure");
        }
    }

    @RequestMapping("/logout.do")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("to logout");
    }


}
