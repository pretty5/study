package string;

/*
*@ClassName:InternTest
 @Description:TODO
 @Author:
 @Date:2018/7/18 10:47 
 @Version:v1.0
*/

public class InternTest {
    public static void main(String[] args) {
        //定义存放字符串 的数组 100*10000
        String[] strings = new String[100 * 100000];
        //unix时间戳：1970年1月1日0点0分0秒开始到目前所经过的秒数
        long start = System.currentTimeMillis();
        final String s1="1";
        final String s2="2";
        final String s3="3";
        final String s4="4";
        for (int i = 0; i < strings.length; i++) {
            if (i%4==0){
                strings[i]=new String("hello"+s1);
            }else if (i%4==1){
                strings[i]=new String("hello"+s2);
            }else if (i%4==2){
                strings[i]=new String("hello"+s3);
            }else if (i%4==3){
                strings[i]=new String("hello"+s4);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
