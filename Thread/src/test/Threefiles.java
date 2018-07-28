package test;


import java.io.File;
import java.io.RandomAccessFile;

public class Threefiles {
    public static void main(String[] args) throws Exception {
        File file = new File("d:\\text\\text1");
        long largelength = file.length();
        long lenth = largelength / 3;
        for (int i = 0; i < 3; i++) {
            File file1 = new File("d:\\text\\ff-" + i);
            long length = 0;
            if (i==2){
                length =  (largelength-lenth*2);
            }else {
                length = lenth;
            }
            RandomAccessFile ra = new RandomAccessFile(file, "r");
            ra.seek(lenth*i);
            new Thread(new Ran(ra,file1,length)).start();
        }
    }
}
