package concurrent;

import java.util.HashSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author GuoYangYang
 * @date 2022/8/28
 */
public class MultiThreadAddObject {
    HashSet<String> set = new HashSet<>();

    public MultiThreadAddObject(String[] ss, int threadCount) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        //CountDownLatch c = new CountDownLatch(threadCount);
        CyclicBarrier cb = new CyclicBarrier(2);
        int length = ss.length, count = length / threadCount;
        for (int i = 0; i < length; i += count) {
            final int start = i;
            final int end = i + count;
            executorService.execute(() -> {      //相当于传入的是run方法，run方法没有形参，不能传形参。
                for (int k = start; k <= end && k < length; k++) {
                    set.add(ss[k]);
                    System.out.println("线程" + Thread.currentThread().getName() + " 正在放第" + k + "个，值为：" + ss[k]);
                }
                //c.countDown();
                try {
                    cb.await();
                    System.out.println("done");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        //c.await();
        //System.out.println("done");     //使用countdownlatch，等到5个线程都执行完后再输出“done”
    }

    public static void main(String[] args) throws InterruptedException {
        int count = 100;
        String[] ss = new String[count];
        for (int i = 0; i < count; i++) {
            ss[i] = String.valueOf(i);
        }
        MultiThreadAddObject m = new MultiThreadAddObject(ss, 6);
        System.out.println(m.set.size());
    }
}