package dao;

import annotition.Bean;
import model.Student;
import model.Teacher;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:StudentDao
 @Description:TODO
 @Author:
 @Date:2018/8/23 9:30 
 @Version:v1.0
*/
@Bean
public class TeacherDao {
    //selectByCid findBycid queryByCid getByCid
    //select find get a b c
    public List<Teacher>  queryByCid(int cid) throws SQLException {
        String sql="select id,cid,name from teacher where cid=?";
        Connection connection = DBUtil.getConnection();
        List<Teacher> teachers = DBUtil.queryByConditions(connection, sql, Teacher.class, cid);
        DBUtil.close();
        return teachers;
    }

}
