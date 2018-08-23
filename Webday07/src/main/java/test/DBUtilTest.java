package test;

/*
*@ClassName:DBUtilTest
 @Description:TODO
 @Author:
 @Date:2018/8/21 11:35 
 @Version:v1.0
*/

import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtilTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtil.getConnection();
        User user1 = DBUtil.queryById(connection,"select * from user where id=?", User.class, 1);
        System.out.println(user1);
        List<User> users = DBUtil.queryByConditions(connection,"select * from user where name= ?", User.class, "abc");
        for (User user :
                users) {
            System.out.println(user);
        }
        //多条件查询
        List<User> abc = DBUtil.queryByConditions(connection,"select * from user where " +
                "name= ? and id= ?", User.class, "abc", 12);
        System.out.println(abc.get(0).toString());

    }
}
