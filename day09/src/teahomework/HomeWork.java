package teahomework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/19 9:08 
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) throws ParseException {
        // q1();
        //q2();
        //q3();
        /*ArrayList list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(5);

        int res4=q31(list);
        System.out.println(res4);
        //1+2+100
        int res=sum(3);
        //System.out.println(res);
        int res2=mul(3);
        //System.out.println(res2);

        int res3=odd(10);*/

        q4();

    }

    private static void q4() {
        ArrayList list = new ArrayList();
        Score score = new Score(99, 99);
        Score score1 = new Score(98, 100);
        Score score2 = new Score(99, 119);

        list.add(score);
        list.add(score1);
        list.add(score2);

        list.sort(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Score s1 = (Score) o1;
                        Score s2 = (Score) o2;

                        if (s1.getSum()-s2.getSum()>0){
                            return -1;
                        }else if (s1.getSum()-s2.getSum()==0){
                            if (s1.getChinese()>s2.getChinese())
                                return -1;
                        }
                        return 1;
                //s1.getSum()-s2.getSum()>0?1:(s1.getSum()==s1.getSum())?s1.getChinese()>s2.getChinese()?1:0)
            }
        });

        System.out.println(list);

    }

    private static int odd(int n) {
        if (n<=0)
            return 0;
        return n*odd(n-2);
    }

    private static int mul(int n) {
        if (n<=1)
            return 1;
        return n*mul(n-1);
    }

    /*
    迭代省内存  迭代代码不好写  迭代告诉计算机怎么干
    递归耗内存  递归好写  递归告诉计算机干什么
     */
    private static int sum(int n) {
        if (n<=1)
            return 1;
        return n+sum(n-1);
    }

    private static int q31(ArrayList list) {
        if (list.size()==1)
            return (Integer) list.get(0);
        Integer head = (Integer) list.get(0);
        list.remove(0);
        return head+q31(list);
    }

    private static void q3() {
        //对于integer类型，如果整数的值是在-128-127之间，则不用创建对象，直接从整数常量池中取
        //否则创建对象
        //why:为了提高效率
        Integer a = 10;
        Integer b = 10;
        System.out.println(a == b);
        Integer c = 1000;
        Integer d = 1000;
        int e = c;
        int f = d;
        Integer g = 127;
        Integer h = 127;
        Integer i = 128;
        Integer j = 128;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(g == h);
        System.out.println(i == j);
        System.out.println(i.equals(j));

    }

    private static void q2() throws ParseException {
        String dateString1 = "1981-11-11 11:11:11";
        String dateString2 = "2018-11-10 12:12:12";
        //使用simpledateformat来对日期格式化
        //要么字符串转日期  要么日期转字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse(dateString1);
        Date date2 = simpleDateFormat.parse(dateString2);

        System.out.println((date1.getTime() - date2.getTime()) / 1000);
    }

    //字符串转为时间戳
    private static void q1() throws ParseException {
        String dateString = "1981-11-11 11:11:11";
        //使用simpledateformat来对日期格式化
        //要么字符串转日期  要么日期转字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateString);
        long time = date.getTime() / 1000;
        System.out.println(time);
        //把日期转化成字符串
        Date now = new Date();
        System.out.println(now);

        String nowString = simpleDateFormat.format(now);

        System.out.println(nowString);

    }
}
