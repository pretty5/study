package dao;

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
public class AccountDao {

    public int update(Connection conn,Account account) throws SQLException {
        String sql="update account set money=? where id=?";
        return DBUtil.update(conn,sql,account.getMoney(),account.getId());
    }
    public Account queryById(Connection conn,int id) throws SQLException {
        String sql="select * from account where id=?";
        Account account = DBUtil.queryById(conn,sql, Account.class, id);
        return account;
    }
}
