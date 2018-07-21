package list;

import homework.Student;

import java.util.ArrayList;

/*
*@ClassName:ListTest
 @Description:TODO
 @Author:
 @Date:2018/7/21 10:01 
 @Version:v1.0
*/
public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");
        //strings.add(1);
        //strings.add(new Student(1,"s"));
        String s = strings.get(0);

        ArrayList<Integer> integers = new ArrayList();
        ///integers.add("adc");
        integers.add(1);
        Integer integer = integers.get(0);

        ArrayList<Student> students = new ArrayList();
        students.add(new Student(1, "tom"));
        Student student = students.get(0);
        System.out.println(student);
    }
}
