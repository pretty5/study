package hashmap;

import java.util.TreeMap;

/*
*@ClassName:TreeMapTest
 @Description:TODO
 @Author:
 @Date:2018/7/20 11:47 
 @Version:v1.0
*/
public class TreeMapTest {
    public static void main(String[] args) {
        Student jack = new Student("jack", 10);
        Student rose = new Student("rose", 11);
        Student tom = new Student("tom", 1);
        Student jerry = new Student("jerry", 2);
        Student aa = new Student("aa", 2);
        TreeMap map = new TreeMap();
        map.put("jack",jack);
        map.put("rose",rose);
        map.put("tom",tom);
        map.put("aa",tom);
        map.put("jerry",jerry);
        System.out.println(map);

    }
}
