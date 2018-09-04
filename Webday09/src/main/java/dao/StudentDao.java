package dao;

import annotition.Bean;
import model.Student;
import org.apache.commons.dbutils.DbUtils;
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
public class StudentDao {
    //selectByCid findBycid queryByCid getByCid
    //select find get a b c
    public List<Student>  queryByCid(int cid) throws SQLException {
        String sql="select id,cid,name from student where cid=?";
        Connection connection = DBUtil.getConnection();
        List<Student> students = DBUtil.queryByConditions(connection, sql, Student.class, cid);
        DBUtil.close();
        return students;
    }
    public Student  queryById(int id) throws SQLException {
        String sql="select id,cid,name from student where id=?";
        Connection connection = DBUtil.getConnection();
        Student student = DBUtil.queryById(connection, sql, Student.class, id);
        DBUtil.close();
        return student;
    }

    public List<Student>  queryAllStudents() throws SQLException {
        String sql="select id,cid,name from student";
        Connection connection = DBUtil.getConnection();
        List<Student> students = DBUtil.queryByConditions(connection, sql, Student.class);
        DBUtil.close();
        return students;
    }

}
