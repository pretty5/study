package com.day01;

public class StringTest {
    public static void main(String[] args) {
        String shortMessage = "hello world";
        shortMessage = "hellllo";

        //int a= shortMessage.length();
        //按住alt+enter 生成前缀
        int length = shortMessage.length();
        //api 应用程序接口
        System.out.println(length);
        System.out.println(shortMessage.charAt(0));
        //截取字符 默认包含头，不包含尾
        char target[] = new char[5];
        shortMessage.getChars(2, 4, target, 0);
        System.out.println(target);
        //第二种截取字符
        System.out.println(shortMessage.substring(1,4));
        //查找第一次出现的位置
        System.out.println(shortMessage.indexOf("l"));
        //查找最后一次出现的位置
        System.out.println(shortMessage.lastIndexOf("l"));
        System.out.println(shortMessage.substring(shortMessage.indexOf("l"),shortMessage.lastIndexOf("l")+1).length());
        //判断字符是否包含下面的字符
        boolean flag = shortMessage.contains("lll");
        System.out.println(flag);

        double a = 20;
        int b = (int) a;
        //final 定义常量
        final  double pai = 3.14;
        //pai = 2.58;
        String str1 = "rullllo";
        //true:不让区分大小写  shortMessage起始位置  比较的子字符串  比较的数量
        System.out.println(shortMessage.regionMatches(true,2,str1,2,5));
       //将字符串转化为数组，5是字符串的偏移量的位置，只显示偏移量的字符，可去掉[5]
        System.out.println(str1.toCharArray()[5]);
        //判断str1是否和下面的子字符串相同，区分大小写
        System.out.println(str1.equals("Rullllo"));


    }


}

