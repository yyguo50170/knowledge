package producerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author GuoYangYang
 * @date 2021/4/25
 */
public class Producer implements Runnable {

    private final ArrayBlockingQueue bucket;
    private boolean stopFlag = false;

    public Producer(ArrayBlockingQueue bucket) {
        this.bucket = bucket;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(p);
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(c);
            t.start();
        }
        Thread.sleep(5000);
        p.stop();
        c.stop();
    }

    public void stop() {
        stopFlag = true;
    }

    @Override
    public void run() {
        while (!stopFlag) {
            try {
                Object o = new Object();
                bucket.add(o);
                System.out.println(Thread.currentThread().getName() + "生产了" + o);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

}
