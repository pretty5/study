package dao;

import annotition.Bean;
import model.Account;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;


/*
*@ClassName:AccountDao
 @Description:TODO
 @Author:
 @Date:2018/8/21 15:53 
 @Version:v1.0
*/
@Bean
public class AccountDao {


    public int update(Account account) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql="update account set money=? where id=?";
        int rows = DBUtil.update(connection, sql, account.getMoney(), account.getId());
        DBUtil.close();
        return rows;
    }
    public Account queryById(int id) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql="select * from account where id=?";
        Account account = DBUtil.queryById(connection,sql, Account.class, id);
        DBUtil.close();
        return account;
    }
}
