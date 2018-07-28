package test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args) throws IOException {
        numsword();
    }

    private static void numsword() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\text\\text3"));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        String s = stringBuilder.toString();
        // String s = "hello world hello henan";
        String[] strings = s.split(" ");
        HashMap hashMap = new HashMap();
        int count = 1;
        for (int i = 0; i < strings.length; i++) {
            if (hashMap.containsKey(strings[i])){
                hashMap.put(strings[i],count+1);
            }else {
                hashMap.put(strings[i],1);
            }
        }
        Set set = hashMap.keySet();
        BufferedWriter bufferedWriter = null;
        for (Object ss:set) {
            bufferedWriter = new BufferedWriter(new FileWriter("d:\\text\\456",true));
            System.out.println(ss+"="+hashMap.get(ss));
            bufferedWriter.write(ss+"="+hashMap.get(ss));
            bufferedWriter.newLine();
            bufferedWriter.close();
        }

    }

}
