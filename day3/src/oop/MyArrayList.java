package oop;

public class MyArrayList {
    //创造一个可以无限存放元素的集合（数组）（容器）
    //先创建一个固定长度如16 长度的数组
    //当数组中的元素数量达到一定程度的时候（0.75),创建一个新的数组
    //比原来的数组翻一倍32长度的，然后遍历数组，将老数组元素复制到新数组
    //删除老数组，之后循环往复
    private  int size=16;
    private  int[] init = new int[size];
    private  int index = 0;
    //从集合取
    public  int get(int index){
        if (index<0){
            System.out.println("下表不能小于0");
            return  -1;
        }
        return  init[index];
    }
    public void add(int num){
        if (index>size*0.75){
            size*=2;
            //创建一个原来两倍大小的数组
            int[] newArr = new int [size];
            //遍历老数组,复制到新数组中
            for (int i = 0; i < init.length; i++) {
                 newArr[i]= init[i];
            }
            init = newArr;
        }
        init[index]= num;
        index++;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 20000; i++) {
            list.add(i);
        }
        System.out.println(list.get(2));
    }
 }
