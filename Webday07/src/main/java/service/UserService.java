package service;

import dao.UserDao;
import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:UserService
 @Description:TODO
 @Author:
 @Date:2018/8/21 15:15 
 @Version:v1.0
*/
//service 事务控制层 业务逻辑层
public class UserService {
    public boolean login(String name,String password){
        UserDao userDao = new UserDao();
        Connection connection =null;
        try {
           connection = DBUtil.getConnection();
            List<User> users = userDao.queryByNameAndPassword(connection,name, password);
            if (users.size()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                return  false;
            }
        }
    }


}
