package ProducerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author GuoYangYang
 * @date 2021/4/25
 */
public class Consumer implements Runnable{
    private ArrayBlockingQueue bucket;
    private boolean stopFlag = false;

    public Consumer(ArrayBlockingQueue bucket) {
        this.bucket = bucket;
    }

    public void stop(){
        stopFlag = true;
    }

    @Override
    public void run() {
        while (!stopFlag){
            try {
                Object o = bucket.take();
                System.out.println(Thread.currentThread().getName()+"取出了"+o);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
