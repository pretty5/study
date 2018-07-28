package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ThreadUtil implements  Runnable {
    private  String path;
    private  String content;

    public ThreadUtil(String path, String content) {
        this.path = path;
        this.content = content;
    }

    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            printWriter.println(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
