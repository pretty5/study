package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
*@ClassName:Homework
 @Description:TODO
 @Author:
 @Date:2018/7/28 9:03 
 @Version:v1.0
*/
public class Homework {
    public static void main(String[] args) throws IOException {
        q1();
    }

    //用多线程的方法将文件分割成三份并保存
    private static void q1() throws IOException {
        File file = new File("d:\\text\\text2");
        //得到文件长度
        long fileLength = file.length();
        long partSize = fileLength / 3;

        for (int i = 0; i < 3; i++) {
            //创建线程同时保存
            //先定义要输出的文件
            File outFile = new File("d:\\text\\iotest3-part-thread-" + i);
            //定义输入流
            RandomAccessFile in = new RandomAccessFile(file, "r");
            //跳到指定位置进行读写
            in.seek(partSize * i);

            //计算每个线程要读取的字节数
            long length = 0;
            //最后一次情况特殊 要单独处理
            if (i == 2) {
                length=fileLength-partSize*2;
            }else{
                length=partSize;
            }

            new Thread(new SaveThread(in, outFile, length)).start();
        }

    }
}
