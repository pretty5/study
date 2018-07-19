package lianxi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("语文",80);
        hashMap.put("数学",86);
        hashMap.put("英语",76);
        hashMap.put("化学",100);
        hashMap.put("计算机",90);

        /*for(Map.Entry<String,Integer> entry : hashMap.entrySet()){//高效遍历方式
            System.out.println(entry.getKey()+"=" + entry.getValue());
        }*/
        for (Map.Entry<String,Integer> antry:hashMap.entrySet()) {
            System.out.println(antry.getKey()+"="+antry
            .getValue());
        }

        Iterator<String> iter = hashMap.keySet().iterator();
        String key = "";
        while(iter.hasNext()){//效率低
            key = iter.next();
            System.out.println(key +"=" + hashMap.get(key));
        }

        hashMap.remove("计算机");
        System.out.println(hashMap);//{数学=86, 化学=100, 语文=80, 英语=76}
    }

}
