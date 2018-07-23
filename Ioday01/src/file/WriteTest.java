package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTest {
    public static void main(String[] args) {
        copytest();
    }

    private static void copytest() {
        try {

            FileOutputStream fos = new FileOutputStream("D:\\text\\text1");
            fos.write("asdsdas".getBytes());
            FileInputStream fis = new FileInputStream("D:\\text\\text1");
            FileOutputStream fos1 = new FileOutputStream("D:\\text\\text2");
            byte[] bytes = new byte[512];
            int length;
            while ((length=fis.read(bytes,0,bytes.length))!=-1){
                fos1.write(bytes,0,length);
            }
            fis.close();
            fos.close();
            fos1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
