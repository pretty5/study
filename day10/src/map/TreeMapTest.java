package map;

import java.util.Comparator;
import java.util.TreeMap;

/*
*@ClassName:TreeMapTest
 @Description:TODO
 @Author:
 @Date:2018/7/20 11:47 
 @Version:v1.0
*/
/*
    对于自定义的key来说，如果需要排序，可以有两种方法
    1.在创建treemap时传入comparator.
    2.自定义key实现comparable接口

 */
public class TreeMapTest {
    public static void main(String[] args) {
        //testPut();
        //testCustomComparator();
        //testComparable();
        testSort();
    }

    private static void testSort() {
        TreeMap map = new TreeMap();
        map.put(5,null);
        map.put(1,null);
        map.put(3,null);
        map.put(2,null);
        map.put(4,null);
        System.out.println(map);
    }

    private static void testComparable() {
        TreeMap map = new TreeMap();
        Student jack = new Student("jack", 10);
        Student rose = new Student("rose", 11);
        Student tom = new Student("tom", 1);
        Student jerry = new Student("jerry", 2);
        map.put(jack,jack);
        map.put(rose,rose);
        map.put(tom,tom);
        map.put(jerry,jerry);
        System.out.println(map);
    }

    private static void testPut() {
        Student jack = new Student("jack", 10);
        Student rose = new Student("rose", 11);
        Student tom = new Student("tom", 1);
        Student jerry = new Student("jerry", 2);
        TreeMap map = new TreeMap();

        map.put("jack",jack);
        map.put("rose",rose);
        map.put("tom",tom);
        map.put("jerry",jerry);

        System.out.println(map);
    }

    private static void testCustomComparator() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student s1 = (Student) o1;
                Student s2 = (Student) o2;
                if (s1.getAge() > s2.getAge()) {
                    return -1;
                } else if (s1.getAge() == s2.getAge()) {
                    return -(s1.getName().compareTo(s2.getName()));
                }
                return 1;
            }
        });
        Student jack = new Student("jack", 10);
        Student rose = new Student("rose", 11);
        Student tom = new Student("tom", 1);
        Student jerry = new Student("jerry", 2);
        map.put(jack,jack);
        map.put(rose,rose);
        map.put(tom,tom);
        map.put(jerry,jerry);
        System.out.println(map);


    }
}
