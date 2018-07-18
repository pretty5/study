package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/*
*@ClassName:ArrayListTest
 @Description:TODO
 @Author:
 @Date:2018/7/18 14:17 
 @Version:v1.0
*/
public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add(1);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        //list.add("hello");

        //list.add(new Person("jack"));

        //list.add(list);


        list.toString();
        System.out.println(list);
        //list.clear();

        System.out.println(list.size());
        boolean flag = list.contains("hello");
        System.out.println("flag: "+flag);
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

        //使用迭代器的方式进行遍历
        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //String s="a,a,a,b,c,d,a,c"



    }


}
