package test;

import model.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:DButilsTest
 @Description:TODO
 @Author:
 @Date:2018/8/21 10:07 
 @Version:v1.0
*/
public class DButilsTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //获取连接
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456");
        //执行查询
        QueryRunner queryRunner = new QueryRunner();
        //?表示占位符，能防止SQL注入（sql字符串 动态拼接 可能会造成sql注入）
        //beanHandler：用来将数据库的查询结果 封装成 对象  方便在java代码中使用
        User user1 = queryRunner.query(connection, "select * from user where id = ?", new BeanHandler<User>(User.class), "ee' or 1= 1#");

        System.out.println(user1);

        String name="abc";
             String sql="select * from user where name='"+name+"'";
        System.out.println(sql);
        List<User> userList = queryRunner.query(connection, sql, new BeanListHandler<User>(User.class));
        for (User user :
                userList) {
            System.out.println(user);
        }

        //select * from user where name='abc';DELETE FROM USER WHERE id=12;''

        /*//查询多个结果
        List<User> users = queryRunner.query(connection, "select * from user", new BeanListHandler<User>(User.class));
        for (User user :
                users) {
            System.out.println(user);
        }*/



    }
}
