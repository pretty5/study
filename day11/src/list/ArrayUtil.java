package list;

import java.util.ArrayList;
import java.util.List;

/*
*@ClassName:ArrayUtil
 @Description:TODO
 @Author:
 @Date:2018/7/21 10:22 
 @Version:v1.0
*/
/*
    静态泛型方法  需要在static关键字后面标记泛型  static<T>
    非静态泛型方法  需要在类上定义
    泛型用的最多的地方就是工具类。

 */
public class ArrayUtil<T> {
    public static int getMid(int[] arr){
        return arr[arr.length/2];
    }
    /*public static Object getMid(Object[] arr){
        return arr[arr.length/2];

    }*/

    public static<A> A getMid(A[] arr){
        return arr[arr.length/2];
    }

    public List<T> asList(T[] arr){
        List<T> ts = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ts.add(arr[i]);
        }
        return ts;
    }



    public static void main(String[] args) {
        String mid = getMid(new String[]{"a", "b"});

        int mid2 = getMid(new int[]{1, 2});

        ArrayUtil<String> arrayUtil = new ArrayUtil<>();
        List<String> strings = arrayUtil.asList(new String[]{"a", "b"});
        System.out.println(strings);
    }

}
