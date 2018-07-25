package homework;

import java.io.*;

/*
*@ClassName:CodeUtil
 @Description:TODO
 @Author:
 @Date:2018/7/25 15:32

 @Version:v1.0
 */

public class CodeUtil {
    public static void main(String[] args) {
        //removeNote("D:\\project\\HelloWorld\\IOday03\\src\\homework\\CodeUtil.java");
   // removeNote("D:\\project\\HelloWorld\\IOday03\\src\\homework\\HomeWork.java");
    removeCode("D:\\project\\HelloWorld\\IOday03\\src\\homework\\HomeWork.java");
    }
    //删除代码保留注释
    private static void removeCode(String javaFilePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFilePath));
            String newJavaFileName=javaFilePath.substring(0,javaFilePath.indexOf('.'))+"RC.java";
            System.out.println(newJavaFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newJavaFileName));
            String line=null;
            boolean flag=false;
            boolean updateClassName=false;
            while ((line=bufferedReader.readLine())!=null){
                if (line.endsWith("*/")){
                    flag=false;
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    continue;
                }
                if (flag){
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    continue;
                }else if (line.startsWith("/*")){
                    flag=true;
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    continue;
                }
                if (line.contains("package")){
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    continue;
                }
                if (line.contains("class")&&updateClassName==false){
                    String className=line.substring(line.lastIndexOf('s')+1,line.indexOf('{')).trim();
                    String newLine = line.substring(0, line.lastIndexOf('s') + 1) + " " + className + "RC{";
                    bufferedWriter.write(newLine);
                    bufferedWriter.newLine();
                    updateClassName=true;
                    continue;
                }
                if (line.contains("//")&&!line.contains("\"//\"")){
                    bufferedWriter.write(line.substring(line.indexOf('/')));
                    bufferedWriter.newLine();
                    continue;
                }

            }
            bufferedWriter.write("}");
            bufferedWriter.newLine();
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {


        }
    }
    //删除注释保留代码
    private static void removeNote(String javaFilePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFilePath));
            String newJavaFileName=javaFilePath.substring(0,javaFilePath.indexOf('.'))+"RN.java";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newJavaFileName));
            String line=null;
            boolean flag=false;
            boolean updateClassName=false;
            while ((line=bufferedReader.readLine())!=null){
                if (line.startsWith("/*")){
                    flag=true;
                    continue;
                }
                if (line.endsWith("*/")){
                    flag=false;
                    continue;
                }
                if (flag==true){
                    continue;
                }

                if (line.contains("//")&&!line.contains("\"//\"")){
                    bufferedWriter.write(line.substring(0,line.indexOf('/')));
                    bufferedWriter.newLine();
                    continue;
                }
                if (line.contains("class")&&updateClassName==false){
                    String className=line.substring(line.lastIndexOf('s')+1,line.indexOf('{')).trim();
                    String newLine = line.substring(0, line.lastIndexOf('s') + 1) + " " + className + "RN{";
                    bufferedWriter.write(newLine);
                    bufferedWriter.newLine();
                    updateClassName=true;
                    continue;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {


        }
    }
}
