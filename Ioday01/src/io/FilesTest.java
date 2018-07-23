package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FilesTest {
    public static void main(String[] args) {
        fileread();
    }

    private static void fileread() {
        try {
            FileInputStream fis = new FileInputStream("d:\\IDEA\\work\\src\\HelloWorld.java");
            byte[] bytes = new byte[512];
            fis.read(bytes);
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

