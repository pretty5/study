package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:DBUtil
 @Description:TODO
 @Author:
 @Date:2018/8/21 11:19 
 @Version:v1.0
*/
//封装了数据库连接池  和  dbutils
public class DBUtil {
    //数据库连接池
    public static DataSource  pool=new ComboPooledDataSource("c3p0-config.xml");
    //public static ThreadLocal<Connection> conn=new ThreadLocal<>();
    //获取连接
    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    //根据id查询
    public static<T> T queryById(Connection conn,String sql,Class<T> clazz,Object id) throws SQLException {
        QueryRunner runner = new QueryRunner();
        T res = runner.query(conn,sql, new BeanHandler<T>(clazz), id);
        return res;
    }
    //根据其他条件查询
    public static<T> List<T> queryByConditions(Connection conn,String sql, Class<T> clazz, Object... conditions) throws SQLException {
        QueryRunner runner = new QueryRunner();
        List<T> res = runner.query(conn,sql, new BeanListHandler<T>(clazz), conditions);
        return res;
    }
    //更新操作
    public static int update(Connection conn,String sql,Object... params) throws SQLException {
        QueryRunner runner = new QueryRunner();
        int rows = runner.update(conn,sql, params);
        return rows;
    }



}
