package teahomework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/21 9:01 
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) {
        //q1();
        q11();
    }

    private static void q11() {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student s1= (Student) o1;
                Student s2= (Student) o2;
                return s2.getScore()-s1.getScore();

            }
        });
        for (int i = 0; i < 100; i++) {
            Student student = new Student(getRandomScore(), getRandomName());
            treeSet.add(student);
            //list.add(student);
        }
        int sum=0;
        //求平均值
        for (Object student:
             treeSet) {
            sum+=((Student)student).getScore();
        }
        //最大值
        System.out.println("max: "+treeSet.first());
        //最小值
        System.out.println("min: "+treeSet.last());

    }

    private static void q1() {
        //创造100个对象
        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            Student student = new Student(getRandomScore(), getRandomName());
            list.add(student);
        }
       // System.out.println(list);
        //求平均值
        int sum=0;
        for (int i = 0; i < 100; i++) {
            Student  student = (Student) list.get(i);
            sum+=student.getScore();
        }
        System.out.println("average: "+(sum/100.0));
        //求最大值
        int max=0;
        int index=0;
        for (int i = 0; i < 100; i++) {
            Student  student = (Student) list.get(i);
            int score = student.getScore();
            if (score>max){
                max=score;
                index=i;
            }
        }
        System.out.println("max: "+max+"name: "+((Student)list.get(index)).getName());
    }

    private static String getRandomName() {
        StringBuilder  name=new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char tmp = (char) ('a' + random.nextInt(26));
            name.append(tmp);
        }
        return name.toString();
    }

    private static String getRandomName(int i) {
        String name="wang";
        return name+i;
    }

    private static int getRandomScore() {
       return new Random().nextInt(100);
    }
}
