package homework;

/*
*@ClassName:ErrorTest
 @Description:TODO
 @Author:
 @Date:2018/7/18 9:11 
 @Version:v1.0
*/
public class ErrorTest {
    public static void main(String[] args) {
        String s="hello";
        try{
            for (;;){
                s=s+s;
                System.out.println(s.length());
            }
        }catch (Error e){
            System.out.println(e.getMessage());
        }

    }
}
