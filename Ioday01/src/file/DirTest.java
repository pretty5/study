package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirTest {
    public static void main(String[] args) {
        List<File> file =getAllfiles(null);
        for (int i = 0; i < file.size(); i++) {
            System.out.println(file.get(i).getAbsolutePath());
        }
    }


    private static List<File> getAllfiles(File dir) {
        ArrayList arrayList = new ArrayList();
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                arrayList.addAll(getAllfiles(files[i]));
            }else{
                arrayList.add(files[i]);
            }
        }
        return  arrayList;
    }
}
