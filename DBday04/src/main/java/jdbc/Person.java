package jdbc;

/*
*@ClassName:Person
 @Description:TODO
 @Author:
 @Date:2018/8/10 11:12 
 @Version:v1.0
*/
//pojo 简单java对象
//orm ：对象关系映射
//把面向对象语言和数据库连接起来的技术
public class Person {
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
