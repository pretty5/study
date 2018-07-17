package com.day01;

import java.util.Scanner;

import static java.lang.String.*;

public class HomeWork {
    public static void main(String[] args) {

        double average;
        int[] x = {1, 2, 3, 4, 4};
        int sum = 0;
        double sum1 = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];

        }
        average = (double) sum / x.length;
        System.out.println(String.format("%.2f", average));
        for (int j = 0; j < x.length; j++) {
            sum1 += (x[j] - average) * (x[j] - average);
        }
        System.out.println(sum1);
        double var = sum1 / x.length;
        System.out.println(String.format("%.2f", var));


        //对
        //char a = 97;
        char a = 97;
        int b = 97;
        //类型不一样

        String str1 = "abc";
        System.out.println(str1.equalsIgnoreCase("AbC"));


        String str2 = "hello";
        //int sum2 = 0;
        for (int i = 0; i < str2.length(); i++) {
            int sum2 = 0;
            if (str2.indexOf(str2.charAt(i)) == i) {
                for (int j = 0; j < str2.length(); j++) {
                    if (str2.charAt(i) == str2.charAt(j)) {
                        sum2++;
                    }
                }
                // if (str2.indexOf(str2.charAt(i)) == i) {
                System.out.println(str2.charAt(i) + "--" + sum2);
            }

        }
        //  System.out.println(sum2);

        //取出一个字母，跟这个字母之后的字符串比较，如果之后的字符串包含了当前的字母
        //则不计入，否则加1，考虑到最后一个字母后边没有字母，因此最终的结果要加1
        int count = 0;
        String str4 = "hello";
        for (int i = 0; i < str4.length(); i++) {
            String ch = str4.substring(i, i + 1);
            String tail = str4.substring(i + 1);
            if (!tail.contains(ch)) {
                ++count;
            }
        }
        System.out.println("个数：" + count);




        //对于任意长度为n的字符串  如果
        //第1个  第n个相等  第2个 第n-1个。。。。n/2 n/2+2
        String test="aabb";
        boolean flag=true;
        char[] chars = test.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char head = chars[i];
            char tail = chars[chars.length - i - 1];
            if (head!=tail){
                flag=false;
                //System.out.println("不是对称字符串");
                break;
            }else{
                continue;
            }
        }
        if (flag){
            System.out.println("是对称字符串");
        }else{
            System.out.println("非对称字符串");
        }
    }
}
