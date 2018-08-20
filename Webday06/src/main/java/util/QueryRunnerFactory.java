package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
*@ClassName:SessionFactory
 @Description:TODO
 @Author:
 @Date:2018/8/20 18:56 
 @Version:v1.0
*/
public class QueryRunnerFactory {
    private static DataSource dataSource;
    public static QueryRunner getQueryRunner(){
        if (dataSource==null){
            dataSource=new ComboPooledDataSource("c3p0-config.xml");

        }
        return new QueryRunner(dataSource);
    }

    public static void main(String[] args) throws SQLException {
        Object query = getQueryRunner().query("select * from user", new ResultSetHandler<Object>() {
            @Override
            public Object handle(ResultSet resultSet) throws SQLException {
                return "hehe";
            }
        });
        System.out.println(query);


    }

}
