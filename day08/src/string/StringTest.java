package string;

/*
*@ClassName:StringTest
 @Description:TODO
 @Author:
 @Date:2018/7/18 9:23 
 @Version:v1.0
*/
/*
  = 右边是否是常量，如果是常量  检查字符串常量池中是否有引用，如果有则返回，如果没有堆上创建对象，引用放入常量池
  = 右边是变量或 new ，直接在堆上创建对象 跟常量池无关。
    通过调用intern，如果常量池中不存在引用，则把该对象的引用放入常量池，如果常量池中存在，则直接返回常量池中的引用。
 */
public class StringTest {
    public static void main(String[] args) {


        testConstrct();
        testEqual();
        testSplit();
    }

    private static void testSplit() {
        String s2="a b   c   d";
        String s="A!b!c d";
        String[] split = s.split("!");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    private static void testConstrct() {
        byte[] byteArr = {'a','b','c','d','e','f','g','h','i','j'};
        char[] charArr = {'0','1','2','3','4','5','6','7','8','9'};
        String oldStr = "zhiyou100";
        StringBuffer buffer = new StringBuffer("bigdata");

        String baStr = new String(byteArr);
        String caStr = new String(charArr);
        String newStr = new String(oldStr);
        String bufferStr = new String(buffer);

        // baStr.equals(caStr);

        System.out.println("从字节数组创建：" + baStr);
        System.out.println("从字符数组创建：" + caStr);
        System.out.println("从老字符串创建：" + newStr);
        System.out.println("从StringBuffer创建：" + bufferStr);
    }

    private static void testEqual() {
        String str1 = "ab" + "cd";  //1个对象
        String str3 = "abcd";
        System.out.println("str1 = str3 : "+ (str1 == str3));
        String str2 = "ab";  //1个对象
        String str6 = "cd";  //1个对象
        String str4 = str2+str6;
        String str5 = "abcd";
        System.out.println("str4 = str5 : " + (str4==str5)); // false

        String str61 = "b";
        String str7 = "a" + str61;
        String str617 = "ab";
        System.out.println("str7 = str67 : "+ (str7 == str617));//false

        final String str8 = "b";
        String str9 = "a" + str8;
        String str89 = "ab";
        System.out.println("str9 = str89 : "+ (str9 == str89));

        String str10="hello";

        String str100=new String("hello");

        String str1000 = str100.intern();

        System.out.println(str10==str1000);
    }


}
