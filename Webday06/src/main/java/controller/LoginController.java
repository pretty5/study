package controller;

import annotition.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*@ClassName:LoginController
 @Description:TODO
 @Author:
 @Date:2018/8/20 16:45 
 @Version:v1.0
*/
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("to login");
    }
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("to logout");
    }


}
