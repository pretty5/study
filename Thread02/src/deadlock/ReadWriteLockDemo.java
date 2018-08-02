package deadlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
*@ClassName:ReadWriteLockDemo
 @Description:TODO
 @Author:
 @Date:2018/7/30 10:56 
 @Version:v1.0
*/
//测试读写锁
// 乐观锁：乐观的认为所有线程对资源进行的是读操作，允许并发读。
//悲观锁：悲观的认为所有线程对资源进行的写操作，不允许并发读。
//共同特点：写一定是串行的。
public class ReadWriteLockDemo {
    public static int count=0;
    //创建一个读写锁
    static ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();


    public static class ReadThread implements  Runnable{
        @Override
        public void run() {
            while (true){
                try{
                    //获取读锁 查看有无写操作，有的话则等待写操作完成再去读。
                    rwLock.readLock().lock();
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"当前count"+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放读锁
                    rwLock.readLock().unlock();
                }
            }


        }
    }

    public static class WriteThread implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    //对写操作加锁
                    rwLock.writeLock().lock();
                    count++;
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "count+1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放写锁
                    rwLock.writeLock().unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReadThread readThread1 = new ReadThread();
        ReadThread readThread2 = new ReadThread();

        WriteThread writeThread1 = new WriteThread();
        WriteThread writeThread2 = new WriteThread();
        //创建两个读线程
        //new Thread(readThread1).start();
        //new Thread(readThread2).start();
        //创造两个写线程
        new Thread(writeThread1).start();
        new Thread(writeThread2).start();

    }

}
