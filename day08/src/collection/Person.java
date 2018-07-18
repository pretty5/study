package collection;

/*
*@ClassName:Person
 @Description:TODO
 @Author:
 @Date:2018/7/18 14:26 
 @Version:v1.0
*/
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
