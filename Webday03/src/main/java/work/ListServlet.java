package work;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        ArrayList<Object> list = new ArrayList<>();
        resp.setContentType("text/html;charset=UTF-8");
        try {
            String sql = "select * from users";
            ResultSet resultSet = JDBCUtil.query(sql);
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    //根据列的下标来找
                    Object object = resultSet.getObject(i);
                    list.add(object);

                }
            }
            JSONArray jsonarray = JSONArray.fromObject(list);
            resp.getWriter().println(jsonarray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



