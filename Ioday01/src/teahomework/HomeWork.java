package teahomework;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/24 9:01 
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) throws Exception {
        //q1();
        //q2();
        //q3();
        q4();
    }

    private static void q4() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("d:\\test\\res.txt");
        int char1;
        int count = 0;
        while ((char1=fileInputStream.read())!=-1){
            if (char1=='\n'){
                count++;
                System.out.println(char1);
            }
        }
        System.out.println("count: "+count);

    }

    private static void q3() throws Exception {
        //打开指定文件
        FileInputStream fileInputStream = new FileInputStream("d:\\test\\123.txt");
        byte[] buffer=new byte[1024];
        int length = fileInputStream.read(buffer);
        fileInputStream.close();

        String content = new String(buffer, 0, length);
        //trim()去掉字符串左右两边的空格
       // System.out.println(content.trim());
        //System.out.println(content.trim().length());
        String[] strings = content.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])){
                map.put(strings[i],map.get(strings[i])+1);
            }else{
                map.put(strings[i],1);
            }
        }
        //将map中的内容输出存到目标文件中
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\test\\res.txt");
        Set<String> keys = map.keySet();
        for (String key :
                keys) {
            String res = key + " " + map.get(key) + "\r\n";
            //fileOutputStream.write(key.getBytes());
            fileOutputStream.write(res.getBytes());
        }
        fileOutputStream.close();

    }

    //2.	创造一个100M大小的文件
    private static void q2() throws Exception {
        String cell="helloworld";
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\test\\iotest3");
        for (int i = 0; i < 1024*100/cell.length(); i++) {
            if (i%1000==0){
                System.out.println(i);
            }

            fileOutputStream.write(cell.getBytes());
        }
        fileOutputStream.close();

    }

    //1.	任意给定两个文件，判断两个文件的内容是否完全一样
    private static void q1() {
        isEqual("d:\\test\\iotest1","d:\\test\\iotest2");
    }

    private static void isEqual(String f1, String f2) {
        File file1 = new File(f1);
        File file2 = new File(f2);
        if (!file1.exists()||!file2.exists()){
            throw new IllegalArgumentException("file is not exists");
        }
        //打开两个文件
        if (file1.length()!=file2.length()){
            System.out.println("不相等");
            return;
        }
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        try {
            fis1 = new FileInputStream(file1);

            fis2 = new FileInputStream(file2);
            int char1;
            int char2;
            while ((char1=fis1.read())!=-1){
                char2=fis2.read();
                if (char1!=char2){
                    System.out.println("不相等");
                    return;
                }
            }
            System.out.println("相等");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis1!=null&&fis2!=null){
                    fis1.close();
                    fis2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
