package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
*@ClassName:ReaderTest
 @Description:TODO
 @Author:
 @Date:2018/7/24 10:37 
 @Version:v1.0
*/

public class ReaderTest {
    public static void main(String[] args) throws IOException {
        //testFileReader();
        testBufferedReader();
    }
    //测试缓冲字符流
    //通过定义缓冲区   减少读写磁盘的次数  减少系统调用的次数  节省时间 提高效率
    //以空间换时间
    private static void testBufferedReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\text\\res.txt"));
        String line =null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }

    private static void testFileReader() throws IOException {
        FileReader fileReader = new FileReader("d:\\test\\123.txt");

        int char1 = fileReader.read();

        System.out.println((char) char1);
        char[] buffer=new char[512];
        int length = fileReader.read(buffer);
        for (int i = 0; i < length; i++) {
            System.out.println(buffer[i]);
        }
        fileReader.close();


    }
}
