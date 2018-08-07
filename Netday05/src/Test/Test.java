package Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       // q1();
       // q2();
          q3();
        //save("http://images9.baihe.com/newHome/member/rows_a1.jpg","d:\\text\\spider\\java.jpg");
    }

    private static void q3() {
        List<String> list = getImagehref();
        int i =1;
        for (String hrefs:
             list) {
           save(hrefs,"d:\\text\\spider\\"+(i++)+".jpg");
            //System.out.println(hrefs);
        }
    }
    private static  void  save(String href,String path){
        int count = 1;
        while (true){
            try {
                //Thread.sleep(5000);
                System.out.println("正在保存："+href);
                URL url = new URL(href);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
              //开始实际的连接
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                //BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                byte[] bytes = new byte[9999];
                System.out.println("正在保存");
                int len = 0;
                while ((len =inputStream.read(bytes,0,bytes.length))!=-1){
                    fileOutputStream.write(bytes,0,len);
                }
                inputStream.close();
                fileOutputStream.close();
                System.out.println("保存成功："+href);
                return;
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println((count++));
                continue;
            }
        }
    }

    private static List<String> getImagehref() {
//        int count =1;
        ArrayList<String> arrayList = new ArrayList<>();
        while (true){
        try {
            URL url = new URL("https://www.6666av.vip/html/tupian/toupai/2018/0713/413172.html");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
           //开始实际的连接
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line=reader.readLine())!=null){
                if (line.contains("http://")){
                    String[] strings = line.split("\"");
                    for (String ips :
                            strings) {
                        if (ips.contains("http://")){
                            if (ips.endsWith("jpg")){
                                arrayList.add(ips);
                            }
                        }
                    }

                }
            }
            reader.close();
            return arrayList;
        } catch (Exception e) {
           // e.printStackTrace();
            continue;
        }
    }
    }

    private static void q2() {
        while (true) {
            try {
                URL url = new URL("http://www.yinwang.org/blog-cn/2018/04/13/csbook-chapter1");
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    if (line.contains("http://")) {
                        String[] strings = line.split("\"");
                        for (String content : strings
                                ) {
                            if (content.contains("http://")) {
                                System.out.println(content);

                            }
                        }
                    }
                }
                reader.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void q1() {
        int count = 0;
        while (true) {
            try {
                URL url = new URL("http://www.yinwang.org/blog-cn/2018/04/13/csbook-chapter1");
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    if (line.trim().startsWith("<title>") && line.trim().endsWith("</title>")) {
                        System.out.println(line.trim().substring(7, line.trim().length() - 8));
                        reader.close();
                        return;
                    }
                }

            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println((count++));
                continue;
            }
        }
    }
}
