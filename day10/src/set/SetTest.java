package set;

import map.Student;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
*@ClassName:SetTest
 @Description:TODO
 @Author:
 @Date:2018/7/20 15:02 
 @Version:v1.0
*/
public class SetTest {
    public static void main(String[] args) {
        //testHashSet();
       // testDistinct();
        testDistinctAndSort();
    }

    private static void testDistinctAndSort() {
        String s1="hello world hello henan hello zhengzhou";
        String[] strings = s1.split(" ");
        Set set = new TreeSet();
        for (String  s:
                strings) {
            set.add(s);
        }
        for (Object o:
                set) {
            System.out.println(o);
        }
    }

    private static void testDistinct() {
        String s1="hello world hello henan hello zhengzhou";
        String[] strings = s1.split(" ");
        HashSet set = new HashSet();


        for (String  s:
                strings) {
            set.add(s);
        }
        for (Object o:
                set) {
            System.out.println(o);
        }
    }

    private static void testHashSet() {
        HashSet set = new HashSet();
        Student s1 = new Student("tom", 18);
        Student s2 = new Student("tom", 19);
        Student s3 = new Student("tom", 19);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        /*for (int i = 0; i < set.size(); i++) {
            System.out.println(set);
        }*/
        for (Object o:
             set) {
            System.out.println(o);
        }

    }

}
