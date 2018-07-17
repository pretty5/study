package oop;

public class Person {
    //类包含两个模块
    //字段/属性
    //方法/函数
    //通常属性都是私有的，为了从外界获取属性，可以通过公开的方法获取
     private int age;

     public  int getAge(){
         return  age;
     }
     public void setAge(int age){
         //this表示当前的这个对象
         this.age=age;
     }

    public static void main(String[] args) {
        Person gailun = new Person();
        System.out.println(gailun.getAge());
        gailun.setAge(22);
        System.out.println(gailun.getAge());

        Person kate = new Person();
        kate.setAge(18);
        System.out.println(kate.getAge());
    }

}
