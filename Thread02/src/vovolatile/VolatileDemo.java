package vovolatile;

/*
*@ClassName:VolatileDemo
 @Description:TODO
 @Author:
 @Date:2018/7/30 14:03 
 @Version:v1.0
*/
/*volatile:可变的，易变的。
再java中，对变量上加volatile关键字，表示这个变量是不稳定的。
一个线程的对其的修改对其他线程可见。
或者说当一个线程修改此变量时，其他线程是知道的。
之所以会出现不可见，是因为jvm或者编译器，对我们的代码进行了优化。
volatile：不能保证同步，或者线程安全。只是能保证jvm或者编译器不对代码优化，只保证可见性。
synchronized :表示强同步   1.互斥 2可见
volatile：表示弱同步  1可见
使用场景：如果变量可能会被多线程修改，同时不担心线程安全问题。可以用volatile
 */
public class VolatileDemo {
    volatile static boolean flag=false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (flag){
                        System.out.println("break");
                        break;
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        flag=true;

    }

}
