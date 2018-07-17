package lianxi;

public class ArrList {
    //定义一个固定长度的数组
    //当长度为75%的时候，数组容量翻倍
    //遍历老数组，赋值给新数组
    private  int size =16;
    private   int [] init = new int[size];
    private  int index=0;
    //存
    public  void  add(int num){

        if (index>size*0.75){
            size *=2;
            int[] ints = new int[size];
            for (int i = 0; i <init.length; i++) {
                ints[i]=init[i];

            }
            init = ints;
        }
        init[index] = num;
        index++;
    }
    public  int get(int index){

        return  init[index];
    }

    public static void main(String[] args) {
        ArrList arrList = new ArrList();
        for (int i = 0; i <19; i++) {
               arrList.add(i);
        }
        System.out.println(arrList.get(18));

    }

}
