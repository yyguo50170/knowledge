package concurrent;

import java.util.concurrent.Semaphore;

public class ThreeThreadAlternatePrint {
    public static void main(String[] args) {
        ThreePrint t = new ThreePrint(1,1,0);
        Thread[] threads = new Thread[4];
        for (int i = 1; i <= 3; i++) {
            threads[i] = new Thread(t, "t" + i);
            threads[i].start();
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            t.stop();   //通过标志位来停止打印
        }

    }
}

/**
 * 三个线程交替打印ABC
 *
 */

class ThreePrint implements Runnable {
    /** 让哪个线程先打印,就设置哪个信号量初始值为1,设置其他信号量的初始值为0 */
    Semaphore s1, s2, s3;
    /** 停止打印的标志 */
    boolean stop;

    public ThreePrint(int s1, int s2, int s3) {
        this.s1 = new Semaphore(s1);
        this.s2 = new Semaphore(s2);
        this.s3 = new Semaphore(s3);
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        try {
            while (!stop) {
                String name = Thread.currentThread().getName();
                if (name.equals("t1")) {
                    s1.acquire();
                    System.out.print("A");
                    s2.release();
                } else if (name.equals("t2")) {
                    s2.acquire();
                    System.out.print("B");
                    s3.release();
                } else if (name.equals("t3")) {
                    s3.acquire();
                    System.out.print("C");
                    s1.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
