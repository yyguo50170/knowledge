import java.util.Date;
import java.util.Timer;
import java.util.concurrent.*;

/**
 * @author GuoYangYang
 * @date 2021/11/10
 */
public class Pool {
    public static void main(String[] args) {
//        Executors.newSingleThreadExecutor();
//        Executors.newFixedThreadPool(5);
//        Executors.newCachedThreadPool();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try{
            for(int i =1; i <= 9;i++){
                Thread.sleep(5L);
                int finalI = i;
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行"+ finalI+" =="+ new Date().getTime());
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }


    }
}
