package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
*@ClassName:Spider
 @Description:TODO
 @Author:
 @Date:2018/8/2 16:37 
 @Version:v1.0
*/
public class Spider {
    public static void main(String[] args) throws IOException {
        //创建一个url
        URL url = new URL("http://www.baihe.com/");
        //打开url 去网络中请求服务器的资源
        URLConnection connection = url.openConnection();
        //获取连接的输入流
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (true){
            String line=reader.readLine();
            if (line==null){
                break;
            }
            System.out.println(line);
        }

        reader.close();


    }
}
