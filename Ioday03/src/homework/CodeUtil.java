package homework;

import java.io.*;

/*
*@ClassName:CodeUtil
 @Description:TODO
 @Author:
 @Date:2018/7/25 15:32
 @Version:v1.1
 */

public class CodeUtil {
    public static void main(String[] args) {
        //removeCode("D:\\project\\HelloWorld\\IOday03\\src\\homework\\WriterTest.java");
    }

    //删除代码保留注释
    private static void removeCode(String javaFilePath) {
        try {
            File javaFile = new File(javaFilePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFilePath));
            String newJavaFileName = javaFilePath.substring(0, javaFilePath.indexOf('.')) + "RC.java";
            PrintWriter writer = new PrintWriter(new FileWriter(newJavaFileName));
            String line = null;
            boolean flag = false;
            boolean updateClassName = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith("*/")) {
                    flag = false;
                    writer.println(line);
                    continue;
                }
                if (flag) {
                    writer.println(line);
                    continue;
                } else if (line.contains("/*") && !line.contains("\"/*\"")) {
                    flag = true;
                    writer.println(line);
                    continue;
                }
                if (line.contains("package")) {
                    writer.println(line);
                    continue;
                }
                if (line.contains("class") && updateClassName == false) {
                    String oldClassName = javaFile.getName().split("\\.")[0];
                    String newLine = line.replace(oldClassName, oldClassName + "RC");
                    writer.println(newLine);
                    updateClassName = true;
                    continue;
                }
                if (line.contains("//") && !line.contains("\"//\"")) {
                    writer.println(line.substring(line.indexOf('/')));

                    continue;
                }

            }
            writer.println("}");
            bufferedReader.close();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

    //删除注释保留代码
    private static void removeNote(String javaFilePath) {
        try {
            File javaFile = new File(javaFilePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFilePath));
            String newJavaFileName = javaFilePath.substring(0, javaFilePath.indexOf('.')) + "RN.java";
            PrintWriter writer = new PrintWriter(new FileWriter(newJavaFileName));
            String line = null;
            boolean flag = false;
            boolean updateClassName = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("/*")) {
                    flag = true;
                    continue;
                }
                if (line.endsWith("*/")) {
                    flag = false;
                    continue;
                }
                if (flag == true) {
                    continue;
                }

                if (line.contains("//") && !line.contains("\"//\"")) {
                    writer.println(line.substring(0, line.indexOf('/')));

                    continue;
                }
                if (line.contains("class") && updateClassName == false) {

                    String oldClassName = javaFile.getName().split("\\.")[0];
                    String newLine = line.replace(oldClassName, oldClassName + "RN");
                    writer.println(newLine);
                    updateClassName = true;
                    continue;
                }
                writer.println(line);
            }
            bufferedReader.close();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {


            e.printStackTrace();
        }
    }
}
