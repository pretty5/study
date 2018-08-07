package zhiyou100;

/*
*@ClassName:Person
 @Description:TODO
 @Author:
 @Date:2018/8/6 14:31 
 @Version:v1.0
*/
public class Person {
    private String id;
    private int age;
    //无参构造
    public Person() {
    }

    public Person(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
