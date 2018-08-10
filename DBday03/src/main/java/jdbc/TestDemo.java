package jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String user = "root";
        String psw = "123456";
        String ulr = "jdbc:mysql://127.0.0.1:3306/school";
         String driverNmae ="com.mysql.jdbc.Driver";
        Class.forName(driverNmae);
        Connection connection = (Connection) DriverManager.getConnection(ulr, user, psw);
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String s = resultSet.getString("s");
            String sname = resultSet.getString("sname");
            String ssex = resultSet.getString("ssex");
            String sage = resultSet.getString("sage");
            System.out.println(s+sage+sname+ssex);
        }
        resultSet.close();
        connection.close();
        DriverManager.registerDriver(new Driver());

    }
}
