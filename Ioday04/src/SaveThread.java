import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
*@ClassName:SaveThread
 @Description:TODO
 @Author:
 @Date:2018/7/26 16:15 
 @Version:v1.0
*/
public class SaveThread implements Runnable {
    //要保存的文件路径
    private String path;
    //要保存的文件内容
    private String content;
    //构造方法初始化
    public SaveThread(String path, String content) {
        this.path = path;
        this.content = content;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        PrintWriter writer = null;
        try {
            //通过Thread.currentThread()来获取当前活动的线程
            System.out.println(Thread.currentThread().getName()+" path"+path+" content"+content);;
            writer = new PrintWriter(path);
            writer.println(content);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+(end-start));

    }
}
