package map;

import java.util.*;

/*
*@ClassName:InverseIndex
 @Description:TODO
 @Author:
 @Date:2018/7/20 16:14 
 @Version:v1.0
*/
/*
    利用hashmap实现倒排索引
 */
public class InverseIndex {
    public static void main(String[] args) {
       /* a hello world
        b hello henan
        c hello zhengzhou*/
        HashMap data = new HashMap();
        data.put("a","hello world");
        data.put("b","hello henan");
        data.put("c","hello zhengzhou");
        //以value分割后的单词为key，以value所对应的key为value
        HashMap index = new HashMap();
        /*hello a b c
        world a
        henan b
        zhengzhou c*/
        Set keys = data.keySet();
        for (Object key :
                keys) {
            String keyString= (String) key;
            //获取书的内容
            String  content = (String) data.get(keyString);
            //获一个个单词
            String[] words = content.split(" ");
            //System.out.println(words.length);
            //如果word在索引中不存在
            for (int i = 0; i < words.length; i++) {
                if (!index.containsKey(words[i])){
                    //用来存放书名
                    ArrayList books = new ArrayList();
                    books.add(keyString);
                    index.put(words[i],books);
                }else{
                    //如果存在  取出书名列表  添加书名
                    List books = (List) index.get(words[i]);
                    books.add(keyString);
                }
            }

        }
        System.out.println(index);

    }
}
