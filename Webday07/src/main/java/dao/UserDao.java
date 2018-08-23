package dao;

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

public class UserDao {
    //增
    public int insert(Connection conn, User user) throws SQLException {
        String sql="insert into user (id,name,password) values(?,?,?)";
        return DBUtil.update(conn,sql,user.getId(),user.getName(),user.getPassword());
    }
    //删除
    public int delete(Connection conn,User user) throws SQLException {
        String sql="delete from user where id=?";
        return DBUtil.update(conn,sql,user.getId());
    }
    //改
    public int update(Connection conn,User user) throws SQLException {
        String sql="update user set  name=? and password=? where id=?";
        return DBUtil.update(conn,sql,user.getName(),user.getPassword(),user.getId());
    }
    //查
    public List<User>  queryByNameAndPassword(Connection conn,String name,String password) throws SQLException {
        String sql="select * from user where  name=? and password=?";
        return DBUtil.queryByConditions(conn,sql,User.class,name,password);
    }

}
