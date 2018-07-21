package map;

import java.util.Objects;

/*
*@ClassName:Student
 @Description:TODO
 @Author:
 @Date:2018/7/20 10:54 
 @Version:v1.0
*/
public class Student implements Comparable{
    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o==null||!o.getClass().equals(getClass())){
            throw new RuntimeException("can not compare");
        }
        Student s2= (Student) o;
        if (getAge() > s2.getAge()) {
            return -1;
        } else if (getAge() == s2.getAge()) {
            return -(getName().compareTo(s2.getName()));
        }
        return 1;

    }
}
