package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/*
*@ClassName:JDBCDemo
 @Description:TODO
 @Author:
 @Date:2018/8/10 9:03 
 @Version:v1.0
*/
public class JDBCDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //测试插入数据
        //testInsert();
        //测试删除
        //testDelete();
        //测试更新
        //testUpdate();
        //测试使用工具类查询
        //testJDBCUtilQuery();
        //testJDBCUtilUpdate();
        //testJDBCUtilInsert();
        testJDBCUtilinsert();
    }

    private static void testJDBCUtilinsert() throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Person person = new Person(20,"rose");
        JDBCutils.insert(person);
    }

    private static void testJDBCUtilInsert() throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Person beijing = new Person(2008, "beijing");
        JDBCUtil.insert(beijing);
    }


    private static void testJDBCUtilUpdate() throws SQLException {
        String sql= "delete from student where S='02'";
        int rows = JDBCUtil.update(sql);
        JDBCUtil.close();
        System.out.println(rows);
    }

    private static void testJDBCUtilQuery() throws SQLException {
        String sql="select * from student";
        ResultSet resultSet = JDBCUtil.query(sql);
        //结果集中列的数量
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()){
            for (int i = 1; i <= columnCount; i++) {
                //根据列的下标来找
                Object object = resultSet.getObject(i);
                System.out.print(object);
            }
            System.out.println();
            System.out.println("--------------------------");
        }
        JDBCUtil.close();

    }

    private static void testUpdate() throws ClassNotFoundException, SQLException {
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/school?charsetEncoding=utf-8";
        //驱动名字
        String driverName = "com.mysql.jdbc.Driver";
        //加载驱动
        Class.forName(driverName);

        Connection connection = DriverManager.getConnection(url, user, password);

        //connection.createStatement();


        String sql="update student set Sname='rose' where Sname='jack'";
        PreparedStatement ps = connection.prepareStatement(sql);
        //返回影响的行数
        int rows = ps.executeUpdate();
        System.out.println("rows: "+rows);
        ps.close();
        connection.close();
    }

    private static void testDelete() throws ClassNotFoundException, SQLException {
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/school?charsetEncoding=utf-8";
        //驱动名字
        String driverName = "com.mysql.jdbc.Driver";
        //加载驱动
        Class.forName(driverName);

        Connection connection = DriverManager.getConnection(url, user, password);

        //connection.createStatement();
        String sql="delete from student where S='123'";
        PreparedStatement ps = connection.prepareStatement(sql);
        //返回影响的行数
        int rows = ps.executeUpdate();
        System.out.println("rows: "+rows);
        ps.close();
        connection.close();
    }

    private static void testInsert() throws ClassNotFoundException, SQLException {
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/school?charsetEncoding=utf-8";
        //驱动名字
        String driverName = "com.mysql.jdbc.Driver";
        //加载驱动
        Class.forName(driverName);

        Connection connection = DriverManager.getConnection(url, user, password);

        //connection.createStatement();
        String sql="insert into student (s,sname) values('123','jack')";
        PreparedStatement ps = connection.prepareStatement(sql);
        //返回影响的行数
        int rows = ps.executeUpdate();
        System.out.println("rows: "+rows);
        ps.close();
        connection.close();
    }
}
