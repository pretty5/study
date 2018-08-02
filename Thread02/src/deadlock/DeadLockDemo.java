package deadlock;

/*
*@ClassName:DeadLockDemo
 @Description:TODO
 @Author:
 @Date:2018/7/30 9:06 
 @Version:v1.0
*/
//模拟一个死锁

/*
死锁：在多线程环境下，存在多个共享资源（锁），线程之间持有对方想要获取的资源（锁），而都得不到释放
，由此造成的程序中止运行。
如何避免或者解决死锁：
1.保证锁(资源)的顺序
2.使用显式锁（可重入锁）
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ("a"){
                    System.out.println(Thread.currentThread().getName()+"get lock a");
                    synchronized ("b"){
                        System.out.println(Thread.currentThread().getName()+"get lock b");
                    }
                    System.out.println(Thread.currentThread().getName()+"free lock b");
                }
                System.out.println(Thread.currentThread().getName()+"free lock a");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ("a"){
                    System.out.println(Thread.currentThread().getName()+"get lock a");
                    synchronized ("b"){
                        System.out.println(Thread.currentThread().getName()+"get lock b");
                    }
                    System.out.println(Thread.currentThread().getName()+"free lock b");
                }
                System.out.println(Thread.currentThread().getName()+"free lock a");
            }
        }).start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized ("b"){
                    System.out.println(Thread.currentThread().getName()+"get lock a");
                    synchronized ("c"){
                        System.out.println(Thread.currentThread().getName()+"get lock b");
                    }
                    System.out.println(Thread.currentThread().getName()+"free lock b");
                }
                System.out.println(Thread.currentThread().getName()+"free lock a");
            }
        }).start();*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ("b"){
                    System.out.println(Thread.currentThread().getName()+"get lock b");
                    synchronized ("a"){
                        System.out.println(Thread.currentThread().getName()+"get lock a");
                    }
                    System.out.println(Thread.currentThread().getName()+"free lock a");
                }
                System.out.println(Thread.currentThread().getName()+"free lock b");
            }
        }).start();*/
    }
}
