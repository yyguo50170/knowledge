import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
                2,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 9; i++) {
                Thread.sleep(5L);
                int finalI = i;
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行" + finalI + " ==" + new Date().getTime());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
