package homework;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
*@ClassName:UserServlet
 @Description:TODO
 @Author:
 @Date:2018/8/16 9:07 
 @Version:v1.0
*/
/*
     json是一种非常通用的数据传输格式，特点是体积小，跨平台。
     json的第三方类库有很多：
     fastjson,jackson,gson...
     推荐使用gson:google开发的java专用的用来解析json的工具包
     使用gson:
     第一步：添加依赖
     第二步：new gson
     第三步：gson.toJson


 */
public class UserServlet extends HttpServlet {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //测试toJSON
        User jack = new User(1, "jack", "123");
        User rose = new User(2, "rose", "123");

        String json = toJSON(jack);
        ArrayList<User> users = new ArrayList<>();
        users.add(jack);
        users.add(rose);
        System.out.println(json);

        String arrayJson = toJSON(users);
        System.out.println(arrayJson);
        //使用gson
        Gson gson = new Gson();

        String json1 = gson.toJson(jack);
        String json2 = gson.toJson(users);
        System.out.println(json1);
        System.out.println(json2);
    }
    private static final Logger log=LoggerFactory.getLogger(UserServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //test1(req,resp);
        //"[{"id":"1","name":"zhangsan","password"："1234"}，{}]"

        test2(req,resp);
        test3(req,resp);


    }

    private void test3(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void test2(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ResultSet resultSet = JDBCUtil.query("select * from user");
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()){
                Integer id = resultSet.getObject(1, int.class);
                String name = resultSet.getObject(2, String.class);
                String password = resultSet.getObject(3, String.class);
                User user = new User(id, name, password);
                users.add(user);
            }
            //list转json
            //String json=toJSON(users);
            //String json2=toJSON(new User());

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("error: ",e);
        } /*catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    //User(id=1,name=jack,password=1234)---->{"id":"1","name":"jack","password":"1234"}
    private static<T> String toJSON(T e) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //user.getId();
        StringBuilder json = new StringBuilder();
        json.append("{");
        Field[] fields = e.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            String methodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method method = e.getClass().getDeclaredMethod(methodName);
            Object fieldValue = method.invoke(e);
            json.append("\"").append(fieldName).append("\":\"").append(fieldValue).append("\"");
            //如果不最后一个不拼接逗号，如果不是拼接
            if (i!=fields.length-1){
                json.append(",");
            }else{
                json.append("}");
            }

        }
        return json.toString();
    }

    private static String toJSON(ArrayList<User> users) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String userJson = toJSON(user);
            json.append(userJson);
            //如果是最后一个
            if (i==users.size()-1){
                json.append("]");
            }else{
                json.append(",");
            }

        }
        return json.toString();
    }

    private void test1(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ResultSet resultSet = JDBCUtil.query("select * from user");
            resp.getWriter().println("<html>");
            while (resultSet.next()){
                Integer id = resultSet.getObject(1, int.class);
                String name = resultSet.getObject(2, String.class);
                String password = resultSet.getObject(3, String.class);
                resp.getWriter().println(id+" "+name+" "+password+"</br>");
            }
            resp.getWriter().println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("error: ",e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
