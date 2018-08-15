import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
*@ClassName:MockServer
 @Description:TODO
 @Author:
 @Date:2018/8/13 11:43 
 @Version:v1.0
*/
//模拟服务器  接收http请求
public class MockServer {
    public static void main(String[] args) throws IOException {
        //模拟接收请求
        //mockReceiveRequest();
        //接收并响应
        mockReceiveRequestAndResponse();
    }

    private static void mockReceiveRequestAndResponse() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        Socket client = serverSocket.accept();
        byte[] buffer=new byte[1024*1024];
        int len = client.getInputStream().read(buffer);
        //将客户端请求显示出来
        System.out.println(new String(buffer,0,len));
        //响应客户端请求
        String response="HTTP/1.1 200 OK\n" +
                "Server: Tengine\n" +
                "Content-Type: text/html\n" +
                "Content-Length: 100\n" +
                "Connection: keep-alive\n" +
                "Date: Sat, 11 Aug 2018 13:19:00 GMT\n" +
                "X-Powered-By: HHVM/3.22.1\n" +
                //"Content-Encoding: gzip\n" +
                "Vary: Accept-Encoding\n" +
                "Via: cache19.l2et15-2[0,200-0,H], cache23.l2et15-2[1,0], kunlun10.cn1418[0,200-0,H], kunlun10.cn1418[1,0]\n" +
                "Age: 138656\n" +
                "X-Cache: HIT TCP_MEM_HIT dirn:0:226396307 mlen:-1\n" +
                "X-Swift-SaveTime: Sun, 12 Aug 2018 06:43:26 GMT\n" +
                "X-Swift-CacheTime: 86400\n" +
                "Timing-Allow-Origin: *\n" +
                "EagleId: df6fef1e15341321960398755e\n" +
                "\n"+
                "<p> <font size=\"20\" color=\"red\">helloworld,hehehehehhehe</font></p>";
        client.getOutputStream().write(response.getBytes());

    }

    private static void mockReceiveRequest() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        Socket client = serverSocket.accept();
        byte[] buffer=new byte[1024*1024];
        int len = client.getInputStream().read(buffer);
        //将客户端请求显示出来
        System.out.println(new String(buffer,0,len));
    }
}
