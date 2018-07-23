package homework;

import java.io.*;
import java.util.*;

public class Homework {
    public static void main(String[] args) {
       // isSame("d:\\text\\text1","d:\\text\\text2");
        //q2();
       //q3("d:\\text\\text3");
        q4("d:\\text\\text3");
    }

    private static void q4(String s) {
        int count = 0;
        File file = new File(s);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while((br.readLine())!=null){
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件的行数："+count);

    }

    private static void q3(String file) {
        try {
           // FileOutputStream fos = new FileOutputStream("d:\\text\\text3");
            File files = new File(file);
            FileInputStream fis = new FileInputStream(files);
            byte[] buffer = new byte[(int) files.length()];
            fis.read(buffer);
            String s = new String(buffer);
            String[] str = s.split(" ");
            HashMap<String,Integer> hashMap = new HashMap();
            for (int i = 0; i <str.length; i++) {
                if (hashMap.containsKey(str[i])){
                    Integer count =  hashMap.get(str[i]);
                    hashMap.put(str[i],count+1);
                }else {
                    hashMap.put(str[i],1);
                }
            }
            FileOutputStream fos = new FileOutputStream("d:\\text\\res.txt");
            Iterator iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()){
               Map.Entry next = (Map.Entry) iterator.next();
                System.out.println(next.getKey()+"---"+next.getValue());
                fos.write(next.getKey().toString().getBytes());
                fos.write("---".getBytes());
                fos.write(next.getValue().toString().getBytes());
                fos.write("\r\n".getBytes());
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void q2() {
        try {
            FileOutputStream fos = new FileOutputStream("d:\\text\\null");
            byte[] buffer = new byte[1024 * 1024*100];
            fos.write(buffer);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void  isSame(String src1,String src2) {
        try {
            FileInputStream fis1 = new FileInputStream(src1);
            FileInputStream fis2 = new FileInputStream(src2);
            byte[] byte1 = new byte[512];
            byte[] byte2 = new byte[512];
            fis1.read(byte1);
            fis2.read(byte2);
            fis1.close();
            fis2.close();
            System.out.println(Arrays.equals(byte1,byte2));
            /*for (int i = 0; i < byte1.length; i++) {
               if ((byte1[i]==byte2[i])){
                   System.out.println("文件内容一样");
               }else {
                   System.out.println("文件不一样");
               }
            }*/
           // System.out.println("文件内容："+(new String(byte1)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
