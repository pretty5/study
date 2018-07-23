package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
*@ClassName:FileTest
 @Description:TODO
 @Author:
 @Date:2018/7/23 9:09 
 @Version:v1.0
*/
/*
测试File类
在java中File表示的是一个文件或者文件夹。

 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //fileAPITest();

        List<File> files = getAllFiles(null);
        //System.out.println(files);
        for (int l = 0; l <files.size(); l++) {
            System.out.println(files.get(l).getAbsolutePath());
        }

    }

    private static List<File> getAllFiles(File dir) {
        //判断dir是否 是个合法的目录
       if (dir == null || !dir.isDirectory()) {
            throw new IllegalArgumentException("is not a dir");
       }

        ArrayList<File> fileList = new ArrayList<>();

        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            //判断该文件是否是目录
            if (files[i].isDirectory()) {
                //把子目录的遍历结果放入  父目录的集合中
                fileList.addAll(getAllFiles(files[i]));
                //fileList.addAll(fileList);
            } else {
                fileList.add(files[i]);
            }
        }
        return fileList;
    }

    private static void fileAPITest() {
        //创建一个文件对象
        File file = new File("d:\\");
        //判断文件是否存在
        boolean exists = file.exists();
        System.out.println("is exists: " + exists);
        //判断该文件是否是目录
        boolean isDir = file.isDirectory();
        System.out.println("isDir: " + isDir);
        //创建目录
       /* boolean success2 = file.mkdir();
        System.out.println("success2: "+success2);

        boolean success = file.createNewFile();
        System.out.println("success: "+success);*/

       /* boolean delete = file.delete();
        System.out.println("delete: "+delete);*/
        //绝对路径
        String absolutePath = file.getAbsolutePath();
        String name = file.getName();

        System.out.println("name: " + name);
        System.out.println("path: " + absolutePath);
        //返回文件最后一次被修改的时间戳
        long lastModified = file.lastModified();
        System.out.println("lastmodified: " + lastModified);
        //获取当前目录下的所有文件
        File[] files = file.listFiles();
        for (File f :
                files) {
            System.out.println(f.getAbsolutePath());
        }
    }


}
