package hashmap;

import java.util.HashMap;

/*
*@ClassName:HashMapTest
 @Description:TODO
 @Author:
 @Date:2018/7/20 10:54 
 @Version:v1.0
*/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Student s1 = new Student("tom", 18);
        Student s2 = new Student("tom", 18);

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode()==s2.hashCode());

        map.put(s1,128);

        map.put(s2,138);

        System.out.println(map.get(s1));

    }


}
