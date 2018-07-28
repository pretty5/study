package syn;

/*
*@ClassName:Counter
 @Description:TODO
 @Author:
 @Date:2018/7/27 10:39 
 @Version:v1.0
*/
public class Counter {

    private int count=0;
    private Object lock=new Object();
    //private Object lock=new Object();
    private static int[] lockArr=new int[1];
    //直接在方法名上加上synchronized  称之为同步方法
    //对于非静态方法的同步  效力等价于this
    public  synchronized void addOne(){
            System.out.println(Thread.currentThread().getName()+" get locka");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName()+"free locka");
        }



    public  void addTwo(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" get lockb");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count+=2;
            System.out.println(Thread.currentThread().getName()+" free lockb");
        }

    }


    public int getCount() {
        return count;
    }
}
