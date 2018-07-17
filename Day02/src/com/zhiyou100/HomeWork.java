package com.zhiyou100;

import java.util.Arrays;
import java.util.Random;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/9 9:06
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) {
        //q1();
        //q2();
        //q3();
        //q4();
        q5();
    }

    private static void q5() {
        //生成点的序列 //1 2 3
        int [][] points=new int[][]{{0,0},{0,1},{1,1},{1,0}};
        double[] dis = new double[6];
        int index = 0;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (i==j){
                    continue;
                }else{
                    int[] step0 = points[0];
                    int[] step1=points[i];
                    int[] step2=points[j];
                    int[] step3=points[6-i-j];
                    //求出step0---step3点的距离
                  double d1= Math.pow( step0[0]-step1[0],2)+ Math.pow( step0[1]-step1[1],2);
                  double d2= Math.pow( step1[0]-step2[0],2)+ Math.pow( step1[1]-step2[1],2);
                  double d3= Math.pow( step2[0]-step3[0],2)+ Math.pow( step2[1]-step3[1],2);
                  double sumDis = d1+d2+d3;
                  dis[index] = sumDis;
                  index++;
                    System.out.println(i+","+j+","+(6-i-j));
                    System.out.println("d1:"+d1+",d2:"+d2+",d3:"+d3+"sumDis"+sumDis);
                }
            }
        }
        Arrays.sort(dis);
        System.out.println(dis[0]);
    }

    //蒙特卡洛模拟
    private static void q4() {
    //随机生成10000个点
        int count=0;
        Random random = new Random();
        //生成一个0~10000之间的整数、
        //i<的值越大，范围越精准
        for (int i = 0; i <1000000 ; i++) {
            //范围使其和半径一直
            int x = random.nextInt(10000);
            int y = random.nextInt(10000);
            //判断生成的点是否在圆内
            //10000为半径，大于半径为超出圆边
            //（x-0）^2+(y-0)^2<=r^2
            if (Math.pow(x,2)+Math.pow(y,2)<Math.pow(10000,2) ){
                //统计出来园内的个数
                count++;
            }

        }
        //圆面积/正方形面积
        //(pai*r^2)/((2r)^2)=count/10000000(这是基数，和for循环长度保持一致)
        //可以得到pai/4=count/1000000
        //4*count/1000000
        System.out.println(4*count/1000000.0);
    }

    //求移动平均
    private static void q3() {
        //用来统计买入信号的个数
        int count = 0;
        int[] prices = new int[]{4, 2, 1, 3, 5, 7, 5, 7, 8, 8};
        for (int i = 0; i < prices.length - 2; i++) {
            double avg = (prices[i] + prices[i + 1] + prices[i + 2]) / 3.0;
            if (avg > prices[i]) {
                count++;
                if (count == 1) {
                    System.out.println("第一次出现买入信号当前是第"+(i+1)+"天");
                }
                System.out.println("可以买入");
            }

        }
        System.out.println("累计出现：" + count + "买入信号");

    }

    //首字母大写  剩余字母小写
    private static void q2() {
        String s = "hello";
        String s1 = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        System.out.println(s1);
    }

    private static void q1() {
        //字符串字母重新排序
        String s = "hello";
        //方法1
        char[] chars = s.toCharArray();
        //调用Arrays的静态方法  sort直接按照从小到大的顺序对数组中的字母排序
        //Arrays.sort(chars);

        //System.out.println(chars);

        //方法2
        //h e l l o  4 3 2 1   n
        //选择排序法（asc）：按照字母的先后顺序，每次拿出一个与后边的字母进行比较，如果前面的
        //比后面的大，则交换位置。每次排序完成以后，最小的总是在最前面。
        //e h l l o

        //2 5 4 1
        /*
         2 5 4 1
         2 5 4 1
         1 5 4 2
         1 4 5 2
         1 2 5 4

         1 2 4 5
         */
       /* for (int i = 0; i < chars.length; i++) {
            //char head = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] < chars[j]) {
                    //交换
                    //char[i]=chars[j];
                    //temporary临时的意思
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    //char[j]=chars[i];
                }
            }
        }
        System.out.println(chars);
*/
        //方法三 冒泡排序
        // 2 5 4 1     1 length
        // 2 5 4 1
        //2 4 5 1
        //2 4 1 5

        //2 4 1 5   //2 lenth-1
        //2 1 4 5

        //1 2 4 5              //i  lenth-i+1

        //  h  e  l l o
        for (int i = 0; i < chars.length - 1; i++) {

            for (int j = 0; j < chars.length - i - 1; j++) {
                //如果前面的值大于后边值 则交换值


                if (chars[j] > chars[j + 1]) {
                    //交换
                    //char[i]=chars[j];
                    //temporary临时的意思
                    char temp = chars[j];

                    chars[j] = chars[j + 1];

                    chars[j + 1] = temp;
                    //char[j]=chars[i];
                }

            }
        }
    }

}
