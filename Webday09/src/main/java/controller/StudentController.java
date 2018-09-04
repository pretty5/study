package controller;

import annotition.Bean;
import annotition.RequestMapping;
import annotition.Require;
import com.google.gson.Gson;
import model.Student;
import model.Teacher;
import service.StudentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
*@ClassName:StudentController
 @Description:TODO
 @Author:
 @Date:2018/8/23 9:57 
 @Version:v1.0
*/
@Bean
@RequestMapping("/student")
public class StudentController {
    @Require
    StudentServiceImpl studentService;
    @RequestMapping("/cid.do")
    public void queryByCid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Student> studentList = studentService.queryByCid(Integer.parseInt(req.getParameter("cid")));
        String json = new Gson().toJson(studentList);
        resp.getWriter().println(json);
    }
    @RequestMapping("/id.do")
    public void queryTeachersById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Teacher> teacherList = studentService.queryTeachersById(Integer.parseInt(req.getParameter("id")));
        String json = new Gson().toJson(teacherList);
        resp.getWriter().println(json);
    }


}
