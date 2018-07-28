package exception;

/*
*@ClassName:ThreadExceptionDemo
 @Description:TODO
 @Author:
 @Date:2018/7/27 9:03 
 @Version:v1.0
*/
//用来测试线程的异常处理方法
//当run方法中出现异常时，jvm会中止后面的代码的运行，进入Thread.UncaughtExceptionHandler的
//uncaughtException方法中运行
public class ThreadExceptionDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //try {
                System.out.println(1 / 0);
                // }catch (Exception e){
                //System.out.println("catch exception");
                // }

            }
        });

        //设置异常处理器
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName());
                e.printStackTrace();
            }
        });

        thread.start();

    }


}
