package concurrent;

import java.util.concurrent.Semaphore;

public class TwoThreadAlternatePrint {

    public static void main(String[] args) {
        //TwoPrint p = new TwoPrint(50, 100);
        TwoPrintUseSemaphore p = new TwoPrintUseSemaphore(1, 0);
        Thread t1 = new Thread(p, "t1"), t2 = new Thread(p, "t2");
        t1.start();
        t2.start();
    }
}

/**
 * 两个线程交替打印数字
 */

class TwoPrint implements Runnable {
    /**
     * 打印的初始值
     */
    int start = 1;
    /**
     * 打印的结束值
     */
    int end = 100;

    public TwoPrint() {
    }

    public TwoPrint(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (start <= end) {
                System.out.println(Thread.currentThread().getName() + ":" + start++);
                this.notify();
                try {
                    if (start != end + 1)
                        this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 两个线程交替打印数字,使用信号量控制
 */
class TwoPrintUseSemaphore implements Runnable {
    Semaphore s1, s2;
    int begin = 1, end = 100;

    public TwoPrintUseSemaphore(int s1, int s2) {
        this.s1 = new Semaphore(s1);
        this.s2 = new Semaphore(s2);
    }

    @Override
    public void run() {
        try {
            while (begin < end) {
                String name = Thread.currentThread().getName();
                if (name.equals("t1")) {
                    s1.acquire();
                    System.out.println(name + ":" + begin++);
                    s2.release();
                } else if (name.equals("t2")) {
                    s2.acquire();
                    System.out.println(name + ":" + begin++);
                    s1.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}