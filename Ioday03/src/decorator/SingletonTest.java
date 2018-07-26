package decorator;

/*
*@ClassName:SingletonTest
 @Description:TODO
 @Author:
 @Date:2018/7/26 10:27 
 @Version:v1.0
*/
public class SingletonTest {
    public static void main(String[] args) {
        
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();
        Singleton instance4 = Singleton.getInstance();
        System.out.println(instance==instance2&&instance3==instance4);
    }
}
