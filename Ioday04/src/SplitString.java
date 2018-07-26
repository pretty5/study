import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
*@ClassName:SplitString
 @Description:TODO
 @Author:
 @Date:2018/7/26 16:05 
 @Version:v1.0
*/
public class SplitString {
    public static void main(String[] args) throws FileNotFoundException {
        //传统方式，不使用多线程
        //way1();
        //使用多线程保存
        way2();

    }

    private static void way2() {
        //long start = System.currentTimeMillis();
        String s="helloworld hellohenan hellozhenghzou";
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
           String path="iotestt"+i;
           String content=strings[i];
           //创建一个runnable接口的对象
           SaveThread saveThread = new SaveThread(path, content);
           //启动一个线程
           new Thread(saveThread).start();
        }
        //long end = System.currentTimeMillis();
        //System.out.println(end-start);
    }

    private static void way1() throws FileNotFoundException {
        long start = System.currentTimeMillis();
        String s="helloworld hellohenan hellozhenghzou";
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            PrintWriter writer = new PrintWriter("iotest" + i);
            writer.println(strings[i]);
            writer.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
