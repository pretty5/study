package io;

/*
*@ClassName:FileStreamTest
 @Description:TODO
 @Author:
 @Date:2018/7/23 10:54 
 @Version:v1.0
*/

import java.io.*;

//测试从磁盘上读取文件
public class FileStreamTest {
    public static void main(String[] args) {
        //simpleRead();
        //complexRead();
        //testWrite();
       // copy("d:\\test\\iotest1","d:\\test\\iotest2");
    }

    private static void copy(String src, String dst) {
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dst);
            //定义缓冲区数组
            byte[] buffer = new byte[1024];
            int length;
            while ((length=fis.read(buffer,0,buffer.length))!=-1){
                fos.write(buffer,0,length);
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void testWrite() {
        try {
            //打开流
            FileOutputStream fos = new FileOutputStream("d:\\text\\iotest1",true);

            //写入数据
            fos.write("helloworld\r\n".getBytes());

            fos.write("helloworld\r\n".getBytes());
            //关闭流
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void complexRead() {
        try {
            FileInputStream fis = new FileInputStream("D:\\IDEA\\work\\src\\HelloWorld.java");

            StringBuilder builder = new StringBuilder();

            byte[] content = new byte[1024];

            int length = 0;

            while ((length = fis.read(content, 0, 100)) != -1) {
                builder.append(new String(content, 0, length));
                System.out.println("length: " + length);
                //content=new byte[100];
            }
            System.out.println(builder.toString());

            fis.close();

            /*int length=fis.read(content,0,10);
            int length2=fis.read(content,10,10);
            System.out.println("length: "+length);
            System.out.println("length2: "+length2);
            System.out.println("content: "+new String(content));*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void simpleRead() {
        try {
            FileInputStream fis = new FileInputStream("D:\\IDEA\\work\\src\\HelloWorld.java");
            byte[] content = new byte[512];
            //通过FileInputStream将文件中的内容以字节数据的形式 读进来；
            int length = fis.read(content);

            int result = fis.read();

           /* for (int i = 0; i < content.length; i++) {
                System.out.println(content[i]);
            }*/
            System.out.println(new String(content));
            System.out.println("length: " + length);
            System.out.println("result: " + result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
