package com.zhiyou100;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;


public class MathTest {
    public static void main(String[] args) {
        //返回最小的
        //System.out.println(Math.min(1,6));
        //返回4舍5入的整数值
       // System.out.println(Math.round(3.1415926));
        //返回0-1之间的随机数
        //System.out.println(Math.random());
        //小数不管为谁，超出即为下一个整数值
        //System.out.println(Math.ceil(2.00001));

        //qi();
        //clock();
        big();
    }

    private static void big() {
        System.out.println(1.01+2.02);
        BigDecimal b1 = new BigDecimal("1.34");
        //不加引号会精度高
        BigDecimal b2 = new BigDecimal(1.34);
        System.out.println(b1);
        System.out.println(b2);
    }

    private static void clock() {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);
        System.out.println(date.getTime());
    }


    private static void qi() {
        //对于种子相同的数，生成的随机数都是一样的
       /* Random r1 = new Random(3);
        Random r2 = new Random(3);
        int i = r1.nextInt(10);
        int i1 = r2.nextInt(10);
        for (int j = 0; j < 10; j++) {
            System.out.print(i+"a:");

            System.out.println(i1);
        }*/

       //使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列
       /* Random r3 = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(r3.nextInt(10)+"");
        }
*/
       //String为字符串常量，而StringBuilder和StringBuffer均为字符串变量

        /*StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc").append("ef");
        StringBuffer stringBuffer = new StringBuffer().append("qw").append("er");
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuffer.toString());*/

        //





    }
}
