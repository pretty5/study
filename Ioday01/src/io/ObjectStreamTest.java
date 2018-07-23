package io;

import java.io.*;

/*
*@ClassName:ObjectStreamTest
 @Description:TODO
 @Author:
 @Date:2018/7/23 15:05 
 @Version:v1.0
*/
//对象流测试
public class ObjectStreamTest {
    public static void main(String[] args) {
        //通过利用ObjectInputStream来反序列化
        //通过利用ObjectOutputStream来序列化
        Person kitty = new Person(18, "kitty");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\test\\kitty"));
            oos.writeObject(kitty);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\test\\kitty"));
            //反序列化
            Person kitty2 = (Person) ois.readObject();

            System.out.println(kitty2==kitty);
            System.out.println(kitty2.getAge()+","+kitty2.getName());
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
