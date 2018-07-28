package work;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Homework {
    public static void main(String[] args) throws Exception {
        File file1 = new File("d:\\text\\cesi");
        q1(file1);
    }

    private static void q1(File s1) throws Exception {
        File[] files = s1.listFiles();
        HashMap<String, String> hashMap = new HashMap<>();
        String line = null;
        for (int i = 0; i < files.length; i++) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i]));
            while ((line=bufferedReader.readLine())!=null){
                //System.out.println(line);
                hashMap.put(files[i].getName(),line);
        }
            bufferedReader.close();

            }
        Set<String> strings = hashMap.keySet();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String d1=s.format(date);
        //System.out.println(d1);
        String s2 = s1.getParent()+"\\merge"+d1;
        BufferedWriter bufferedWriter = null;
        for (String ss :strings) {
            String res = ss+"--"+hashMap.get(ss)+"\r\n";
            //System.out.println(res);
            bufferedWriter = new BufferedWriter(new FileWriter(s2,true));
            bufferedWriter.write(res);
            bufferedWriter.close();
        }



    }


}
