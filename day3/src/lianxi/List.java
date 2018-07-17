package lianxi;

public class List {
    //创建一个固定长度的数组
    //当数组大于0.75，创建一个新的数组，翻了一倍，并把老数组转到新数组
    //往复
    private int size = 16;
    private int[] init = new int[size];
    int index = 0;

    //取
    public  int get(int index){
        if (index<0){
            return  -1;
        }
        return  init[index];
    }

    //存数据
     public  void  add(int num) {
         if (index > size * 0.75) {
             size *= 2;
             int[] newInit = new int[size];

             for (int i = 0; i < init.length; i++) {
                 newInit[i] = init[i];
             }
             init = newInit;
         }

         init[index]=num;
         index++;
    }

    public static void main(String[] args) {
        List list = new List();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(list.get(17));
    }
}
