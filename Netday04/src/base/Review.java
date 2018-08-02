package base;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
*@ClassName:Review
 @Description:TODO
 @Author:
 @Date:2018/8/2 15:40 
 @Version:v1.0
*/
public class Review {
    public static void main(String[] args) throws IOException {
        test1();
        test2();
    }

    private static void test2() throws IOException {
        //字节流向字符流转换用转换流
        //new BufferedReader(new InputStreamReader(System.in));
        //new BufferedReader(new InputStreamReader(new FileInputStream("d:\\test")));
        //new BufferedWriter(new FileWriter("d:\\test\\aa"));
        //new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\test\\aa")));
       /* new PrintWriter("d\\test\\aa");
        new PrintWriter(new FileOutputStream("d:\\test\\aa"));
        new PrintWriter(new FileWriter("d:\\test\\aa"));
        new PrintWriter(new File("d:\\test\\aa"));*/
        //new ObjectOutputStream(new FileOutputStream("d:\\test\\aa"));
        //new ObjectOutputStream(System.out);
    }

    //集合遍历
    private static void test1() {
        //创建一个hashmap
        Map<String, String> map = new HashMap<>();
        map.put("abc","abc");
        map.put("def","abc");
        map.put("hi","abc");
        map.put("jk","abc");
        //第一种遍历
        Set<String> keySet = map.keySet();
        for (String key:
             keySet) {
            System.out.println(key+map.get(key));
        }
        //第二种遍历 entry
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry:entries){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
        //迭代器
        Set<String> keySet2 = map.keySet();
        //获取迭代器
        Iterator<String> iterator = keySet2.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+","+map.get(key));
        }
    }
}
