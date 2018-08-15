import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegiestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if ((name!=null&&password!=null)&&(!name.trim().equals("")&&!password.trim().equals(""))){
            System.out.println("regiest succes");
            resp.getWriter().println("regiest succes");
            try {
                RegiestServlet.Insert(name,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            resp.getWriter().println("regiest faile");
        }
    }

    private static void Insert(String x, String psw) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/school";
        //驱动名字
        String driverName = "com.mysql.jdbc.Driver";
        //加载驱动
        Class.forName(driverName);

        Connection connection = DriverManager.getConnection(url, user, password);

        //connection.createStatement();

        String sql="insert into users (name,password)  values('"+x+"','"+psw+"')";
        PreparedStatement ps = connection.prepareStatement(sql);
         ps.executeUpdate();
//        System.out.println("rows: "+rows);
        ps.close();
        connection.close();
    }


}
