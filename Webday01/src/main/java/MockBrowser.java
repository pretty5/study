import java.io.IOException;
import java.net.Socket;

/*
*@ClassName:MockBrowser
 @Description:TODO
 @Author:
 @Date:2018/8/13 11:14 
 @Version:v1.0
*/
//模拟 浏览器 发送http请求
public class MockBrowser {

    public static void main(String[] args) throws IOException {
        mockGet();
        //mockPost();
    }
    //模拟post请求
    private static void mockPost() throws IOException {
        String header="POST /wp-content/themes/runoob/option/user/log.php HTTP/1.1\n" +
                "Host: www.runoob.com\n" +
                "Connection: keep-alive\n" +
                "Content-Length: 56\n" +
                "Accept: application/json, text/javascript, */*; q=0.01\n" +
                "Origin: http://www.runoob.com\n" +
                "X-Requested-With: XMLHttpRequest\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36\n" +
                "Content-Type: application/x-www-form-urlencoded; charset=UTF-8\n" +
                "Referer: http://www.runoob.com/\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Accept-Language: zh-CN,zh;q=0.9\n" +
                "Cookie: Hm_lvt_8e2a116daf0104a78d601f40a45c75b4=1530793460,1531279841,1531279945,1531883568; Hm_lpvt_8e2a116daf0104a78d601f40a45c75b4=1531883568; Hm_lvt_3eec0b7da6548cf07db3bc477ea905ee=1533261998,1533262068,1533262075,1534130198; Hm_lpvt_3eec0b7da6548cf07db3bc477ea905ee=1534131270; SERVERID=7decc9f806c1b4907a0fb8af8275b71e|1534131285|1534131285; checklogin_ajax=true"
                +"\n"
                +"\n"
                +"username=1234&password=12341234&action=signin&remember=1";
        Socket socket = new Socket("www.runoob.com", 80);
        socket.getOutputStream().write(header.getBytes());
        byte[] buffer=new byte[1024*1024];
        int len = socket.getInputStream().read(buffer);
        //将服务端的结果显示出来
        System.out.println(new String(buffer,0,len));
    }

    private static void mockGet() throws IOException {
        String header="GET /java/java-tutorial.html HTTP/1.1\n" +
                "Host: www.runoob.com\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\n" +
                "Referer: http://www.runoob.com/\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Accept-Language: zh-CN,zh;q=0.9\n" +
                "Cookie: Hm_lvt_8e2a116daf0104a78d601f40a45c75b4=1530793460,1531279841,1531279945,1531883568; Hm_lpvt_8e2a116daf0104a78d601f40a45c75b4=1531883568; Hm_lvt_3eec0b7da6548cf07db3bc477ea905ee=1533261998,1533262068,1533262075,1534130198; Hm_lpvt_3eec0b7da6548cf07db3bc477ea905ee=1534130210\n"
                //请求参数要跟请求头隔开一个空行
                +"\n"+"";

        Socket socket = new Socket("www.runoob.com", 80);
        socket.getOutputStream().write(header.getBytes());
        byte[] buffer=new byte[1024*1024];
        int len = socket.getInputStream().read(buffer);
        //将服务端的结果显示出来
        System.out.println(new String(buffer,0,len));


    }
}
