package extend;

/*
*@ClassName:ExtendsTest
 @Description:TODO
 @Author:
 @Date:2018/7/12 11:24 
 @Version:v1.0
*/
//用于测试继承
public class ExtendsTest {
    public static void main(String[] args) {
        //创建一个父类的对象
        Father xiaotoubaba = new Father("xiaotoubaba", 30);
        //创建一个子类对象
        Child datouerzi = new Child("datouerzi", 3);

        System.out.println(datouerzi.getAge());

        datouerzi.drive();

        datouerzi.zuoren();
        //xiaotoubaba.
        Son gailun = new Son("gailun", 1);
        Girl kate = new Girl("kate", 1);

        kate.setToy("xiaodao");
        gailun.setToy("dabaojian");

        System.out.println(kate.getToy());
        System.out.println(gailun.getToy());




    }
}
