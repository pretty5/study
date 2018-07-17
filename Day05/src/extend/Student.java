package extend;

/*
*@ClassName:Student
 @Description:TODO
 @Author:
 @Date:2018/7/12 15:16 
 @Version:v1.0
*/
public class Student {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            //如果已经是student类型
            //判断id是否相等


           /* Student that = (Student) obj;
            return this.getId().equals(that.getId());*/
            return  this.getId().equals(((Student) obj).getId());
        }

        return false;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        //创建一个学生
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");
        Student tmp = new Student("s1");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(tmp));
    }
}
