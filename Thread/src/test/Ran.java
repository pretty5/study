package test;

import java.io.*;

public class Ran implements Runnable {
    private RandomAccessFile ra;
    private File file;
    private  long length;

    public Ran(RandomAccessFile ra, File file, long length) {
        this.ra = ra;
        this.file = file;
        this.length = length;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            int cha = 0;
            int num =0;
           while (true){
               cha = ra.read();
               num++;
               if (num>length){
                   break;
               }
               fos.write(cha);
           }
            fos.close();
           ra.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
