package service;

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
public class AccountService {
    public void transfer(int senderId, int receiverId, int money) {
        AccountDao accountDao = new AccountDao();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            Account sender = accountDao.queryById(conn, senderId);
            Account receiver = accountDao.queryById(conn, receiverId);
            sender.setMoney(sender.getMoney() - money);
            receiver.setMoney(receiver.getMoney() + money);
            accountDao.update(conn, sender);
            accountDao.update(conn, receiver);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
