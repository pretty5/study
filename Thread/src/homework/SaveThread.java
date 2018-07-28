package homework;

import java.io.*;

/*
*@ClassName:SaveThread
 @Description:TODO
 @Author:
 @Date:2018/7/28 9:07 
 @Version:v1.0
*/
public class SaveThread implements Runnable{
    //定义输入的流
    private RandomAccessFile in;
    //输出的目的地
    private File outFile;
    //定义读取的长度
    private long length;

    public SaveThread(RandomAccessFile in, File outFile, long length) {
        this.in = in;
        this.outFile = outFile;
        this.length=length;
    }

    //2000
    //2048
    @Override
    public void run() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            //byte[] buffer=new byte[1024];
            //int num=0;

            int char1=0;
            //累计读取的字节数
            long acc=0;
            //BufferedWriter

            while (true){
                char1=in.read();
                acc++;
                if (acc>length){
                    break;
                }
                /*//如果读的字节超过设定的大小
                if (acc>this.length){

                }*/
                fileOutputStream.write(char1);

            }

            in.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
