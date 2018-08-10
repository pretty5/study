package jdbc;

import java.sql.*;

public class JDBCDemo {
    //测试使用jdbc连接mysql数据库
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        testSelect();
    }

    private static void testSelect() throws ClassNotFoundException, SQLException {
        //定义用户名和密码，以及数据库地址
        String user="root";
        String password ="123456";
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        //驱动名字
        String driverName = "com.mysql.jdbc.Driver";
        //加载驱动
        Class.forName(driverName);
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //开始执行sql语句
        String sql="select * from student";
        //创建一个声明 相当于查询请求
        //PreparedStatement  预编译sql 可以防止sql注入，保证代码安全
        PreparedStatement statement = connection.prepareStatement(sql);
        //执行请求 返回结果集
        ResultSet resultSet = statement.executeQuery();
        //遍历结果集，输出
        while (resultSet.next()){
            String s = resultSet.getString("s");
            String sname = resultSet.getString("sname");
            String sage = resultSet.getString("sage");
            String ssex = resultSet.getString("Ssex");
            System.out.println("s:"+s+" sname:"+sname+" sage:"+sage+" ssex:"+ssex);
        }
        //关闭结果集
        resultSet.close();
        //关闭连接
        connection.close();

    }

}
