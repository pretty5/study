package homework;

import java.util.*;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/20 9:00 
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) {
        //q1();
        q2();
       // q31();
       // q32();

    }

    private static void q32() {
        RegionUtil.loadData("henan zhengzhou gongyi,henan zhengzhou xingyang,henan kaifeng lankao,jiangsu suzhou gusu,jiangsu nanjing xuanwu,jiangsu nanjing jianye");
        RegionUtil.getCountries("jiangsu");
    }

    private static void q31() {
        RegionUtil.loadData("henan zhengzhou gongyi,henan zhengzhou xingyang,henan kaifeng lankao,jiangsu suzhou gusu,jiangsu nanjing xuanwu,jiangsu nanjing jianye");
        RegionUtil.getCitys("jiangsu");
    }

    private static void q2() {
        String s="hello world hello henan hello zhengzhou";
        String[] strings = s.split(" ");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            String word = strings[i];
            String head = word.substring(0, 1);
            if (hashMap.containsKey(head)){
                List list = (List) hashMap.get(head);
                list.add(word);
            }else{
                //如果不包含  需要创建一个新的key value:new ArrayList
                ArrayList arrayList = new ArrayList();
                arrayList.add(word);
                hashMap.put(head,arrayList);
            }
        }
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry next = (Map.Entry) iterator.next();

            System.out.println(next.getKey()+":"+next.getValue()+"size: "+((List)next.getValue()).size());

        }




    }

    private static void q1() {
        //
        String s="hello world hello henan hello zhengzhou";
        //对字符串切割
        String[] strings = s.split(" ");
        //
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        //System.out.println(strings);
        //以单词为key，以其出现的次数作为value，添加key，当key存在时，取出value+1,key不存在，则将
        //value置为1
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            if (hashMap.containsKey(strings[i])){
                Integer count = (Integer) hashMap.get(strings[i]);
                //count++;
                hashMap.put(strings[i],count+1);
            }else{
                hashMap.put(strings[i],1);
            }
        }
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());

        }

        Iterator iterator1 = hashMap.keySet().iterator();

        while (iterator1.hasNext()){
            String key = (String) iterator1.next();

            System.out.println(key+":"+hashMap.get(key));

        }

        Set keySet = hashMap.keySet();
        for (Object key :
                keySet) {
            System.out.println((String)key+":"+hashMap.get(key));
        }

    }
}
