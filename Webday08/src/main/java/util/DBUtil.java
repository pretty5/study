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
    public static DataSource pool = new ComboPooledDataSource("c3p0-config.xml");
    //每个线程都拥有的独有的一个容器
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    //获取线程拥有的连接  如果有 则直接返回  如果没有则先从数据库连接池中获取  然后放入线程的threadlocal
    public static Connection getConnection() throws SQLException {
        //当前线程拥有的threadlocal
        if (threadLocal.get() == null) {
            threadLocal.set(pool.getConnection());

        }
        return threadLocal.get();
    }

    //根据id查询
    public static <T> T queryById(Connection conn, String sql, Class<T> clazz, Object id) throws SQLException {
        QueryRunner runner = new QueryRunner();
        T res = runner.query(conn, sql, new BeanHandler<T>(clazz), id);
        return res;
    }

    //根据其他条件查询
    public static <T> List<T> queryByConditions(Connection conn, String sql, Class<T> clazz, Object... conditions) throws SQLException {
        QueryRunner runner = new QueryRunner();
        List<T> res = runner.query(conn, sql, new BeanListHandler<T>(clazz), conditions);
        return res;
    }

    //更新操作
    public static int update(Connection conn, String sql, Object... params) throws SQLException {
        QueryRunner runner = new QueryRunner();
        int rows = runner.update(conn, sql, params);
        return rows;
    }
    //处理非事务的关闭
    public static void close() throws SQLException {
        if (threadLocal.get() != null) {
            //首先判断当前连接是否处于事务状态
            if (threadLocal.get().getAutoCommit()) {
                //归还连接
                threadLocal.get().close();
                //清除threadlocal中的连接引用
                threadLocal.remove();
            }
        }
    }
    //处理事务的关闭
    public static void txnClose() throws SQLException {
        if (threadLocal.get() != null) {
                //归还连接
                threadLocal.get().close();
                //清除threadlocal中的连接引用
                threadLocal.remove();
        }

    }


}
