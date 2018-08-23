package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/*
*@ClassName:C3p0Test
 @Description:TODO
 @Author:
 @Date:2018/8/21 11:08 
 @Version:v1.0
*/
//测试使用数据库连接池
public class C3p0Test {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("c3p0-config.xml");
        for (int i = 0; i < 100; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            //连接使用完毕  放入池中  其他人可以继续使用 并非真正的关闭
            connection.close();
            connection.close();
        }


    }
}
