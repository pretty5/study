package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
*@ClassName:TransactionDemo
 @Description:TODO
 @Author:
 @Date:2018/8/10 16:09 
 @Version:v1.0
*/
public class TransactionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/school?charsetEncoding=utf-8";
        //驱动名字
        String driverName = "com.mysql.jdbc.Driver";
        //加载驱动
        Class.forName(driverName);

        Connection connection = DriverManager.getConnection(url, user, password);

        //进行事务处理
        try{
            //关闭自动提交
            connection.setAutoCommit(false);
            String sql1="update account set money=money-100 where id=1";
            String sql2="update account set money=money+100 where id=2";
            connection.prepareStatement(sql1).executeUpdate();
            connection.prepareStatement(sql2).executeUpdate();
            //手动提交
            connection.commit();

        }catch (Exception e){
            //出现异常可以回滚 回滚到事务开始前的状态
            connection.rollback();
        }finally {
            connection.close();
        }



    }
}
