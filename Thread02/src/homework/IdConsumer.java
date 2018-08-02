package homework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.concurrent.BlockingQueue;

/*
*@ClassName:IdConsumer
 @Description:TODO
 @Author:
 @Date:2018/7/31 9:37 
 @Version:v1.0
*/
public class IdConsumer implements Runnable {
    private BlockingQueue<String> queue;
    //要保存的目标文件
    private String fileName;
    //在外边创建流节省资源
    private PrintWriter writer;

    public IdConsumer(BlockingQueue<String> queue, String fileName) {
        this.queue = queue;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String id = queue.take();
                String md5 = getMD5(id);
               // System.out.println(id + "," + md5);
                saveIntoFile(id, md5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //保存结果到文件
    private void saveIntoFile(String id, String md5) throws FileNotFoundException {
        //懒加载  在需要用的时候再去创建。可以提高性能，减少系统启动时间。
        if (writer == null) {
            writer = new PrintWriter(fileName);
        }
        writer.println(id + "," + md5);
        //刷到磁盘
        writer.flush();
        //writer.close();
    }
    //关闭流
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }

    private String getMD5(String id) {

        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = id.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
