package list;

import java.util.ArrayList;

/*
*@ClassName:GenericTest
 @Description:TODO
 @Author:
 @Date:2018/7/21 10:59 
 @Version:v1.0
*/
/*
    在java数组时协变（协同变化）  父类的引用可以指向子类的数组
    泛型时不能协变的
    ? 在泛型中表示通配符
    ？ extends T 表示 T类型及其任意子类
    当 使用？ extends T 类型的泛型，编译器会阻止数据的写入，但是可以进行数据的读取
    ？ super T 表示 T类型及其父类
    当 使用？ super T 类型的泛型，不可以进行数据的读取，但可以进行数据写入

    PECS:生产者继承，消费者super
    producer extends  consumer super


 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ad");

        ArrayList<? extends Number> numbers = new ArrayList<>();

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        numbers=integers;
        //numbers=doubles;


        //numbers.add(1);

        ArrayList<? super Number> numbers2 = new ArrayList<>();
        //numbers2=integers;


        numbers2.add(1);
        numbers2.add(1.2);

        //numbers2.add("ad");


        Number[]  numArr=new Number[4];
        Integer[]  intArr=new Integer[4];
        numArr=intArr;

    }

}
