package homework;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.*;

/*
*@ClassName:HomeWork
 @Description:TODO
 @Author:
 @Date:2018/7/31 9:03 
 @Version:v1.0
*/
public class HomeWork {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //q2();
        //q3();
        q4();
    }
    //测试StringUtil
    private static void q4() {
        boolean empty = StringUtils.isEmpty("123");
        System.out.println(empty);

    }

    private static void q3() {
        //capacity表示容量
        ArrayBlockingQueue<String> ids = new ArrayBlockingQueue<>(20);
       //生产者线程
        IdProducer idProducer = new IdProducer(ids);
        new Thread(idProducer).start();
        //消费者线程
        IdConsumer idConsumer = new IdConsumer(ids, "d:\\test\\thread1");
        new Thread(idConsumer).start();

    }

    private static void q2() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        int sum=0;
        for (int i = 1; i <= 100; i++) {
            //1--10
            //11-20
            if (i%10==1){
                //i---i+9
                int tmp=i;
                Future<Integer> future = pool.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int partSum = 0;
                        for (int j = tmp; j < tmp + 10; j++) {
                            partSum += j;
                        }
                        return partSum;
                    }
                });
                sum+=future.get();
            }

        }
        System.out.println("sum="+sum);
    }
}
