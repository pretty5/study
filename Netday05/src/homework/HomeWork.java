package homework;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/8/3 9:01 
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) throws IOException {
        //q1();
        //q2();
        q3();
        //saveToLocal("http://www.runoob.com/wp-content/uploads/2013/12/java.jpg","d:\\test\\spider\\java.jpg");
       // mockBroswer();
    }
    //模拟浏览发送http请求
    private static void mockBroswer() {
        String header="GET /java/java-tutorial.html HTTP/1.1\n" +
                "Host: www.runoob.com\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\n" +
                "Referer: https://www.baidu.com/link?url=Cj-KjMTgnbCyoD5_dzKeUhihl0k9y4L0ROGnb5nFW5je8GhmLYUXiLVUlnPlX4yhFh8lZ3gjUnoC5KB61G__hq&wd=&eqid=ae5a7b660006f1ba000000035b63b7c1\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Accept-Language: zh-CN,zh;q=0.9\n" +
                "Cookie: Hm_lvt_8e2a116daf0104a78d601f40a45c75b4=1530793460,1531279841,1531279945,1531883568; Hm_lpvt_8e2a116daf0104a78d601f40a45c75b4=1531883568; Hm_lvt_3eec0b7da6548cf07db3bc477ea905ee=1533197954,1533261770,1533261998,1533262068; Hm_lpvt_3eec0b7da6548cf07db3bc477ea905ee=1533262068\n" +
                "\n"
                +"";
        try {
            Socket socket = new Socket("www.runoob.com", 80);
            System.out.println(socket);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(header.getBytes());
            //得到服务器的响应
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            while (true){
                String line = reader.readLine();
                if (line==null){
                    break;
                }
                System.out.println(line);
            }
            //System.out.println(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void q3() throws IOException {
        //获取链接
        List<String> hrefs = getImageHref();
        //遍历链接
        for (String href :
                hrefs) {
            //将网络上的图片，通过发送请求的方式，保存到本地
            saveToLocal(href, "d:\\text\\spider\\" + href);
        }

    }

    private static void saveToLocal(String href, String path) {
        int count=0;
        while (true) {
            try {
                System.out.println("正在保存："+href);
                //请求href
                InputStream inputStream = new URL(href).openConnection().getInputStream();
                //定义一个文件输出流
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                //定义缓冲区
                byte[] buffer = new byte[4096];
                int len = 0;
                while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                }
                inputStream.close();
                fileOutputStream.close();
                System.out.println("保存成功："+href);
                return;
            } catch (Exception e) {

                System.out.println("第" + (count++) + "次");
                continue;
            }

        }

    }

    private static List<String> getImageHref() {
        String url = "http://www.yinwang.org/blog-cn/2018/04/13/csbook-chapter1";
        int count = 1;
        ArrayList<String> hrefs = new ArrayList<>();
        //循环请求，直到请求成功
        while (true) {
            try {
                URLConnection connection = new URL(url).openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    //截取http链接
                    if (line.contains("http://")) {
                        //遇到特殊字符需要转义
                        String[] strings = line.split("\"");
                        for (String content :
                                strings) {
                            if (content.contains("http://")) {
                                //System.out.println(content);
                                //将获取的链接存到集合中
                                if (content.endsWith("jpg")) {
                                    hrefs.add(content);
                                }
                            }
                        }
                    }
                    //System.out.println(line);
                }
                reader.close();
                return hrefs;

            } catch (Exception e) {
                System.out.println("第" + (count++) + "次");
                continue;
            }
        }
    }

    //获取链接
    private static void q2() {
        String url = "http://www.yinwang.org/blog-cn/2018/04/13/csbook-chapter1";
        int count = 1;
        //循环请求，直到请求成功
        while (true) {
            try {
                URLConnection connection = new URL(url).openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    //截取http链接
                    if (line.contains("http://")) {
                        //遇到特殊字符需要转义
                        String[] strings = line.split("\"");
                        for (String content :
                                strings) {
                            if (content.contains("http://")) {
                                System.out.println(content);

                            }
                        }
                    }
                    //System.out.println(line);
                }
                reader.close();
                return;

            } catch (Exception e) {
                System.out.println("第" + (count++) + "次");
                continue;
            }
        }

    }

    private static void q1() {
        String url = "http://www.yinwang.org/blog-cn/2018/04/13/csbook-chapter1";
        int count = 1;
        //循环请求，直到请求成功
        while (true) {
            try {
                URLConnection connection = new URL(url).openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    //去掉两边的空格，判断是否以”<title>“开头，且以</title>
                    if (line.trim().startsWith("<title>") && line.trim().endsWith("</title>")) {
                        System.out.println(line.trim().substring(7, line.trim().length() - 8));
                        reader.close();
                        return;
                    }
                    //System.out.println(line);
                }

            } catch (Exception e) {
                System.out.println("第" + (count++) + "次");
                continue;
            }
        }


    }
}
