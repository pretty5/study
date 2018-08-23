package dao;

import annotition.Bean;
import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:UserDao
 @Description:TODO
 @Author:
 @Date:2018/8/21 14:53 
 @Version:v1.0
*/
//dao层表示的对数据库的表的增删改查的封装 不支持事务
@Bean
public class UserDao {
    //增
    public int insert(User user) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql="insert into user (id,name,password) values(?,?,?)";
        int rows = DBUtil.update(connection, sql, user.getId(), user.getName(), user.getPassword());
        DBUtil.close();
        return rows;
    }
    //删除
    public int delete(User user) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql="delete from user where id=?";
        int rows = DBUtil.update(connection, sql, user.getId());
        DBUtil.close();
        return rows;
    }
    //改
    public int update(User user) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql="update user set  name=? and password=? where id=?";
        int rows = DBUtil.update(connection, sql, user.getName(), user.getPassword(), user.getId());
        DBUtil.close();
        return rows;
    }
    //查
    public List<User>  queryByNameAndPassword(String name,String password) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql="select * from user where  name=? and password=?";
        List<User> users = DBUtil.queryByConditions(connection, sql, User.class, name, password);
        DBUtil.close();
        return users;
    }

}
