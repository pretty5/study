package writer;

import homework.HomeWork;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

/*
*@ClassName:WriterTest
 @Description:TODO
 @Author:
 @Date:2018/7/24 14:22 
 @Version:v1.0
*/
//使用bufferedwriter一定要注意在最后要关闭流，否则会出现数据丢失
//可以使用flush方法，强制将缓冲区中的数据刷到磁盘上。
public class WriterTest {
    public static void main(String[] args) throws IOException {
        //testBufferedWriter();
        //testPrintWriter();
        //testOutputStreamWriter();
        testProperties();

    }

    private static void testProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("d:\\test\\db.txt"));
        //System.out.println(properties);
        String user = (String) properties.get("user");
        System.out.println(user);
        //加载位于项目src下的配置文件
        //类加载器的作用就是从src目录下加载文件
        properties.load(HomeWork.class.getClassLoader().getResourceAsStream("db.properties"));

        System.out.println(properties);

    }

    //将输出字节流转化成输出字符流
    private static void testOutputStreamWriter() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\test\\iotest7")));
        //new BufferedReader(new InputStreamReader(new FileInputStream("")))
        //new BufferedWriter(new FileWriter())
        /*FileOutputStream fileOutputStream = new FileOutputStream("d:\\test\\iotest7");
        //通过转换流转换成字符流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);*/

        bufferedWriter.write("de");
    }

    //打印字符流
    private static void testPrintWriter() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new FileOutputStream("d:\\test\\iotest6"));
        writer.print("helloworld");
        writer.println("helloworld");
        writer.println("helloworld");
        writer.close();
    }

    ///cost: 48  cost 1
    private static void testBufferedWriter() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:\\test\\iotest5"),5);
        String s="helloworld";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
             //s=s+s;
             bufferedWriter.write(s);
            //bufferedWriter.flush();
        }
        bufferedWriter.close();
        long end = System.currentTimeMillis();
        System.out.println("cost: "+(end-start)/1000);
        //System.out.println("write over");
        //bufferedWriter.close();


    }
}
