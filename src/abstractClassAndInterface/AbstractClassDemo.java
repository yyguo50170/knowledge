package abstractClassAndInterface;

public abstract class AbstractClassDemo {
    int a = 0;
    int b = 1;

    public AbstractClassDemo() {
        a = 2;
        b = 3;
    }

    public void run() {
        System.out.println("running");
    }

    public abstract int sub(int a, int b);
}
