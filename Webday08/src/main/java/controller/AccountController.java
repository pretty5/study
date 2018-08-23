package controller;

import annotition.Bean;
import annotition.RequestMapping;
import annotition.Require;
import dao.AccountDao;
import service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*@ClassName:AccountController
 @Description:TODO
 @Author:
 @Date:2018/8/21 16:19 
 @Version:v1.0
*/
@Bean
@RequestMapping("/account")
public class AccountController {
    @Require
    private AccountService accountService;

    @RequestMapping("/transfer.do")
    public void transfer(HttpServletRequest req, HttpServletResponse resp){
        String senderId = req.getParameter("senderId");
        String receiverId = req.getParameter("receiverId");
        String money = req.getParameter("money");
        accountService.transfer(Integer.parseInt(senderId),Integer.parseInt(receiverId),Integer.parseInt(money));
    }
}
