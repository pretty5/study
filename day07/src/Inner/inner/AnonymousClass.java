package Inner.inner;

/*
*@ClassName:AnonymousClass
 @Description:TODO
 @Author:
 @Date:2018/7/17 10:59 
 @Version:v1.0
*/
//测试匿名内部类
public class AnonymousClass {
    public static void main(String[] args) {
       /* Inner inner = new Inner() {
            @Override
            public String getName() {
                return "jack";
            }
        };
        System.out.println(inner.getName());*/

        Inner inner = new Inner() {
            @Override
            public String getName() {
                return "tom";
            }
        };

        Fly bird = new Bird();

        bird.fly();



        new Fly() {
            @Override
            public void fly() {
                System.out.println("i can fly too");
            }

            @Override
            public void swim() {
                System.out.println("i can swim");
            }

            @Override
            public void run() {
                System.out.println("i can run");
            }
        }.fly();



        //flyToo.fly();


    }
}
