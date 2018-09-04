package service;

import model.Student;
import model.Teacher;

import java.util.List;

public interface StudentService {
    List<Student> queryByCid(int cid);
    List<Teacher> queryTeachersById(int id);
    //select find get
}
