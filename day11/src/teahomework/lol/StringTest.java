package teahomework.lol;

/*
*@ClassName:StringTest
 @Description:TODO
 @Author:
 @Date:2018/7/17 18:38 
 @Version:v1.0
*/
public class StringTest {
    public static void main(String[] args) {
        final String s1="h";
        String s2="h";
        System.out.println(s1==s2);


        String s3=new String("h");
        String s4=new String("h");

        String intern = s3.intern();

        System.out.println(s3==s4);

        System.out.println(s1==intern);


        String s5=s1+"h";
        String s6="hh";


        System.out.println(s5==s6);



    }
}
