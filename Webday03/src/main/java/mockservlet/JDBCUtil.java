package mockservlet;

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
    //执行更新
    public static int update(String sql) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        int rows = ps.executeUpdate();
        return rows;
    }
    //02 rose 2017-10-10 女
    public static<T> int insert(T e) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
         //insert into person (id,name) values(1,'jack');
        StringBuilder sql=new StringBuilder();
        sql.append("insert into ");
        String className = e.getClass().getName();
        String tableName = className.substring(className.lastIndexOf(".") + 1);
        sql.append(tableName).append(" ");
        sql.append("(");
        //定义stringbuilder用来拼接值
        StringBuilder values = new StringBuilder();

        //得到字段
        Field[] fields = e.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //获取字段名
            String fieldName = fields[i].getName();
            //根据字段名获取get方法
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            //根据方法名，以及参数的属性得到方法 同时调用方法 返回的是字段的值
            Object value = e.getClass().getDeclaredMethod(getMethodName).invoke(e);

            String valueString = String.valueOf(value);

            //最后一个字段不加‘，’
            if (i==fields.length-1){
                sql.append(fields[i].getName()).append(") values (");
                values.append("'").append(valueString).append("'").append(")");
                //达到最后一个字段 将sql与后面值拼接，完成最终的sql
                sql.append(values);
            }else{
                //字段的拼接
                sql.append(fieldName).append(",");
                //值的拼接
                values.append("'").append(valueString).append("'").append(",");
            }

        }
        System.out.println(sql);
        return update(sql.toString());
    }
}
