package deadlock;

import java.util.concurrent.locks.ReentrantLock;

/*
*@ClassName:LockDemo
 @Description:TODO
 @Author:
 @Date:2018/7/30 9:34 
 @Version:v1.0
*/
//测试可重入锁 显式锁 lock锁
public class LockDemo {

    public static void main(String[] args) {
        //创建一个显式锁 可重入锁==可嵌套锁：锁中有锁
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //lock.lock就是加锁 作用等同于synchronized
                try{
                    lockA.lock();
                    System.out.println(Thread.currentThread().getName()+"get lock A");
                    lockB.lock();
                    System.out.println(Thread.currentThread().getName()+"get lock B");
                    System.out.println(1/0);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    //释放锁
                    System.out.println(Thread.currentThread().getName()+"free lock A");
                    lockA.unlock();
                    System.out.println(Thread.currentThread().getName()+"free lock B");
                    lockB.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //lock.lock就是加锁 作用等同于synchronized
                try{
                    lockA.lock();
                    System.out.println(Thread.currentThread().getName()+"get lock A");
                    lockB.lock();
                    System.out.println(Thread.currentThread().getName()+"get lock B");
                    System.out.println(1/0);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    //释放锁
                    System.out.println(Thread.currentThread().getName()+"free lock A");
                    lockA.unlock();
                    System.out.println(Thread.currentThread().getName()+"free lock B");
                    lockB.unlock();
                }

            }
        }).start();
    }

}
