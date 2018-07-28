package homework;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class HomeWork {
    public static void main(String[] args) throws Exception {
        //q1();
       // q3();
        q2();

    }

    private static void q2() throws Exception {
        String fileName="d:\\text\\text3";
        //取得文件的长度
        File largeFile = new File(fileName);

        long length = largeFile.length();
        //定义每一部分的大小
        long partSize = Math.round(length / 3.0);

        FileInputStream fis = new FileInputStream(fileName);

        String smallFileName="";
        FileOutputStream fos=null;//10 3
        int count=1;
        for (long i = 1; i <length+1 ; i++) {
            smallFileName=fileName+"-part-"+count;
            if (fos==null){
                fos=new FileOutputStream(smallFileName);
            }
            int char1 = fis.read();
            if (char1==-1){
                break;
            }
            fos.write(char1);
            if (i%partSize==0){

                if (count!=3){
                    fos.close();
                    fos=null;
                }

                count++;
            }

        }
    }

    private static void q3() throws Exception {
        //读取去配置文件
        Properties properties = new Properties();
        properties.load(HomeWork.class.getClassLoader().getResourceAsStream("conf.properties"));
       //获取属性
        timer(Integer.parseInt(properties.getProperty("interval")), Integer.parseInt(properties.getProperty("frequency")));

    }

    private static void timer(int interval, int frequency) throws Exception {
        while (true){
            Thread.sleep(interval * 1000);
            for (int i = 0; i < frequency; i++) {
                System.out.println("helloworld");
            }
        }
    }

    private static void q1() throws Exception {
       List<File> fileList =getSmallFiles("d:\\text\\cesi");
       mergeSmallFiles(fileList,getLargeFileName());
      //  System.out.println(fileList);

    }

    private static void mergeSmallFiles(List<File> fileList, String largeFileName) throws Exception {
        for (int i = 0; i < fileList.size(); i++) {
            //BufferedReader reader = new BufferedReader(new FileReader(fileList.get(i)));
           String content = getFileContent(fileList.get(i));
           if (content!=null){
               BufferedWriter writer = new BufferedWriter(new FileWriter(largeFileName,true));
               writer.write(fileList.get(i).getName()+"="+content);
               writer.newLine();
               writer.close();
           }
        }
    }

    private static String getFileContent(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null){
           stringBuilder.append(line);
        }
        reader.close();
        return stringBuilder.toString();
    }
    private static String getLargeFileName() {
        //获取当日日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd");
        String dateString = simpleDateFormat.format(new Date());
        return "d:\\text\\merge"+dateString;
    }

    private static List<File> getSmallFiles(String dir) {
        //获取文件大小小于4kb的文件
        //String dir = "d:tetx\\cesi";
        File file = new File(dir);
        if (!file.isDirectory()){
            throw  new IllegalArgumentException("is not dir");
        }
        //获取目录下的所有的文件列表
        File[] files = file.listFiles();
        ArrayList<File> filelist = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            //获取文件大小
            long fileSize = files[i].length();
            if (fileSize<4*1024){
                filelist.add(files[i]);
            }
        }
        return  filelist;
    }
}
