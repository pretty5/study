package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*
*@ClassName:ArrayListTest
 @Description:TODO
 @Author:
 @Date:2018/7/18 14:17 
 @Version:v1.0
*/
public class ArrayListTest {
    public static void main(String[] args) {

        //testAPI();
        distinct();
        //对集合中的元素排序
        // 1 3 2 5 8
        // 1 2 3 5 8
        //快速排序
        //首先随机找出一个元素。然后将剩下的元素跟这个取出的元素比较。如果比它小，则放左边，如果比它
        //大，则放右边。依次类推，直到全局有序

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(1);


        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer num1 = (Integer) o1;
                Integer num2 = (Integer) o2;
               /* if (num1 > num2) {
                    return -1;
                } else if (num1 < num2) {
                    return 1;
                } else {
                    return 0;
                }*/
              //return num1>num2?1:-1;

                return num1.compareTo(num2);
            }
        });


        System.out.println(list);
        //ArrayList result = new ArrayList();
        //System.out.println(quickSort(list));


    }

    private static ArrayList quickSort(ArrayList list) {
        if (list.size() <= 1) {
            return list;
        }
        //拿出第一个元素做标杆，
        Integer head = (Integer) list.get(0);
        //定义两个集合，分别为左右
        ArrayList left = new ArrayList();
        ArrayList right = new ArrayList();
        ArrayList mid = new ArrayList();
        //     0
        // 1 3 2 5 8 1  r

        //   1
        // 1 3 2 5 8 1
        ArrayList result = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            Integer element = (Integer) list.get(i);
            if (element < head) {
                left.add(element);
            } else if (element > head) {
                right.add(element);
            } else {
                mid.add(element);
            }
        }
        //添加左边结果
        result.addAll(quickSort(left));
        //添加中间值
        result.addAll(mid);
        //添加右边值
        result.addAll(quickSort(right));

        return result;

    }

    private static void distinct() {
        String s = "a,a,a,b,c,a,d";
        String[] strings = s.split(",");
        ArrayList list = new ArrayList();
        for (int i = 0; i < strings.length; i++) {
            if (!list.contains(strings[i])) {
                list.add(strings[i]);
            }
        }
        System.out.println(list);
    }

    private static void testAPI() {
        ArrayList list = new ArrayList();

        list.add(1);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.add("hello");

        list.add(new Person("jack"));

        //list.add(list);


        list.toString();
        System.out.println(list);
        //list.clear();

        System.out.println(list.size());
        boolean flag = list.contains("hello");
        System.out.println("flag: " + flag);
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

        //使用迭代器的方式进行遍历
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


}
