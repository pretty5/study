package controller;

import annotition.Bean;
import annotition.RequestMapping;
import annotition.Require;
import model.Student;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
*@ClassName:ViewController
 @Description:TODO
 @Author:
 @Date:2018/8/23 10:49 
 @Version:v1.0
*/
@Bean
@RequestMapping("/view")
public class ViewController {
    @Require
    StudentServiceImpl studentService;
    @RequestMapping("/stus.do")
    public void queryStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.queryAllStudents();
        //请求中设置属性
        req.setAttribute("studentList",studentList);
        //将数据渲染至视图
        req.getRequestDispatcher("/students.jsp").forward(req,resp);

    }


}
