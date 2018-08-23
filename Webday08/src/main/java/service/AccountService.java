package service;

import annotition.Bean;
import annotition.Require;
import dao.AccountDao;
import model.Account;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/*
*@ClassName:AccountService
 @Description:TODO
 @Author:
 @Date:2018/8/21 15:55 
 @Version:v1.0
*/
@Bean
public class AccountService {
    @Require
    AccountDao accountDao;
    public void transfer(int senderId, int receiverId, int money) {
       // AccountDao accountDao = new AccountDao();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            Account sender = accountDao.queryById( senderId);
            Account receiver = accountDao.queryById(receiverId);
            sender.setMoney(sender.getMoney() - money);
            receiver.setMoney(receiver.getMoney() + money);
            accountDao.update( sender);
            accountDao.update(receiver);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                DBUtil.txnClose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
