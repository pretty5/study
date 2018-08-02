package executorservice;

import java.util.concurrent.*;

/*
*@ClassName:CallableTest
 @Description:TODO
 @Author:
 @Date:2018/7/30 15:18 
 @Version:v1.0
*/
/*
    实现callable（回调）可以拥有返回值。返回Future
    future表示将来的结果，可以通过异步的方式获取。
    两者组合，可以提高系统的性能。（减少了阻塞等待时间）

 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //future表示异步的概念。
        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        //dosomethingelse
        //通过调用future的get获取运行结果，如果结果不存在，则该方法阻塞等待，直到有结果返回。
        Integer sum = future.get();

        System.out.println(sum);
    }
}
