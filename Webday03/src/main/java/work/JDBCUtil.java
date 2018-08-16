package work;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ResourceBundle;

/*
*@ClassName:JDBCUtil
 @Description:TODO
 @Author:
 @Date:2018/8/10 9:46 
 @Version:v1.0
*/
//jdbc工具类
public class JDBCUtil {
    private static String user;
    private static String password;
    private static String url;
    private static String driverName;
    private static Connection conn;

    //初始化上面几个属性
     static{
        //加载配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        url = bundle.getString("url");
        password = bundle.getString("password");
        user = bundle.getString("user");
        driverName = bundle.getString("driverName");
        try {
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    //关闭连接
    public static void close() throws SQLException {
        if (conn != null) {
            conn.close();
            conn=null;
        }
    }

    //执行查询
    public static ResultSet query(String sql) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }

}
