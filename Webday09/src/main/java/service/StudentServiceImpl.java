package service;

import annotition.Bean;
import annotition.Require;
import dao.StudentDao;
import dao.TeacherDao;
import model.Student;
import model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/*
*@ClassName:StudentServiceImpl
 @Description:TODO
 @Author:
 @Date:2018/8/23 9:43 
 @Version:v1.0
*/
@Bean
public class StudentServiceImpl implements StudentService {
    private static final Logger log=LoggerFactory.getLogger(StudentServiceImpl.class);
    @Require
    private StudentDao studentDao;
    @Require
    private TeacherDao teacherDao;
    @Override
    public List<Student> queryByCid(int cid) {
        try {
            return studentDao.queryByCid(cid);
        } catch (SQLException e) {
            log.error("error:",e);
            //e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Teacher> queryTeachersById(int id) {
        try {
            Student student = studentDao.queryById(id);
            List<Teacher> teachers = teacherDao.queryByCid(student.getCid());
            return teachers;
        } catch (SQLException e) {
            log.error("error:",e);
        }
        return null;
    }

    public List<Student> queryAllStudents() {
        try {
            return studentDao.queryAllStudents();
        } catch (SQLException e) {
            log.error("error:",e);
            //e.printStackTrace();
        }
        return null;
    }


}
