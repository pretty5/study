package zhiyou100;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Properties;



/*
*@ClassName:ReflectDemo
 @Description:TODO
 @Author:
 @Date:2018/8/6 14:30 
 @Version:v1.0
*/
/*
 知识点：
        根据字段的名字  得到方法（set）的名字--本质上是字符串拼接
        根据反射class.getDeclaredMethods 获取方法
        根据反射method.getParameterTypes 获取参数类型
        根据参数类型，来动态的将字符串转化成指定类型。
        通过method.invoke来调用方法

 */
public class ReflectDemo {
    public static void main(String[] args) {
        //f1();
        try {
            f2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //反射应用测试
    private static void f2() throws Exception {
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\test\\reflect\\info.txt"));
        String content = IOUtils.toString(new FileReader("d:\\test\\reflect\\info.txt"));
        //System.out.println(content);
        String[] lines = content.split("\n");
        boolean flag=true;
        int lineNum=0;
        //System.out.println();
        for (String line :
                lines) {
            System.out.println(line);
            String tag = myGetTag(line);
            if (tag.equals("person")&&flag){
                //得到类
                Class<?> clazz = Class.forName("com.zhiyou100." + tag.substring(0, 1).toUpperCase() + tag.substring(1));
                //Person person = (Person) clazz.newInstance();
                //获取示例对象
                Object o = clazz.newInstance();
                String nextLine = getNextLine(lineNum++, content);
                String nextNextLine = getNextLine(lineNum, content);
                //获取下一行的标记
                String nextLineTag = myGetTag(nextLine);
                //获取第二行标记
                String nextNextLineTag = myGetTag(nextNextLine);
                //得到第一个方法
                String methodName = getMethodName(nextLineTag);
                String methodName2 = getMethodName(nextNextLineTag);

                String lineText = getLineText(nextLine);
                String lineText2 = getLineText(nextNextLine);
                //获取方法
                Method method = myGetMethod(clazz,methodName);
                Method method2 = myGetMethod(clazz,methodName2);

                //Method[] declaredMethods = clazz.getDeclaredMethods();
                //调用方法
                myInvoke(method,o,lineText);
                myInvoke(method2,o,lineText2);
                System.out.println(o);
                //method.invoke(o,lineText);

            }

            //System.out.println(tag);

        }
    }



    private static void myInvoke(Method method, Object o,String lineText) throws InvocationTargetException, IllegalAccessException {
        //得到方法的参数类型
        Class<?>[] types = method.getParameterTypes();
        //type[0] 因为set方法只有一个参数
        if (types[0].getName().equals("int")){
            method.invoke(o,Integer.valueOf(lineText));
        }else if (types[0].getName().equals("lang")){
            method.invoke(o,Long.valueOf(lineText));
        }else{
            method.invoke(o,lineText);
        }

    }

    //由于事先并不知道参数的类型，因此需要根据方法名与之匹配得到方法
    //具体就是通过遍历的方式 找到方法
    private static Method myGetMethod(Class<?> clazz, String methodName) {
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(methodName)){
                return methods[i];
            }
        }

        return null;
    }

    //获取标签中内容
    private static String getLineText(String nextLine) {
        return nextLine.substring(nextLine.indexOf(">")+1,nextLine.lastIndexOf("<"));
    }

    //给定标签名  获得方法名
    private static String getMethodName(String nextLineTag) {
        //age
        return "set"+nextLineTag.substring(0,1).toUpperCase()+nextLineTag.substring(1);
    }

    //得到当前行的下一行
    private static String getNextLine(int lineNum,String content) {
        //得到当前的行数
        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (i==lineNum+1){
                return lines[i];
            }
            continue;
        }
        return null;

    }

    private static String myGetTag(String line) {
       if (line.startsWith("</")){
           return line.substring(2,line.indexOf(">"));
       }else{
           return line.substring(1,line.indexOf(">"));
       }
        //line.substring(0,)
    }

    //反射基本测试
    /*private static void f1() throws Exception {
        //通过类名.class获取 类
        Class clazz=Person.class;

        //通过对象 getClass也可以获取对象所属的类
        Person tom = new Person("tom", 12);
        Class<? extends Person> clazz2 = tom.getClass();
        //通过class的静态方法获取
        Class<?> clazz3 = Class.forName("com.zhiyou100.Person");

        System.out.println(clazz.getName());
        System.out.println(clazz2.getName());
        System.out.println(clazz3.getName());
        //获取在此类中声明的字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field :
                fields) {
            //得到字段 的名字
            System.out.println(field.getName());
            System.out.println(field.getType().toString());
        }

        //获取此类中声明 的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method :
                methods) {
            System.out.println(method.getName());
            //获取方法的返回值
            System.out.println(method.getReturnType().getName());

        }

        Person person = new Person();
        //相当于new person()
        Person instance = (Person) clazz.newInstance();
        //获取setid方法  相当于person.setId("jack")
        Method method = clazz.getMethod("setId", String.class);
        //调用setid方法 第一个object表示方法所属的对象 剩下object表示方法需要的参数
        method.invoke(person,"jack");
        //相当于person.getId();
        Method getId = clazz.getMethod("getId");
        String res = (String) getId.invoke(person);


        System.out.println(res);


        // System.out.println(person.getId());
    }*/
}
