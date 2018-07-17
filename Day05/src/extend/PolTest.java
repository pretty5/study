package extend;

/*
*@ClassName:PolTest
 @Description:TODO
 @Author:
 @Date:2018/7/12 14:03 
 @Version:v1.0
*/
//测试多态
//多态：父类的引用  指向子类的对象
/*
因为父类的引用指向了不同类型子类的对象，
造成了在调用相同方法的时候，出现了多种状态，这就是多态

 */

public class PolTest {
    public static void main(String[] args) {
        Father gailun = new Son("gailun", 1);
        Father kate=new Girl("kate",1);


        gailun.drive();
        kate.drive();
    }

}
