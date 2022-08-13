package abstractClassAndInterface;

public class InterfaceImpl implements InterfaceDemo {
    @Override
    public void fly() {
        System.out.println("impl's fly");
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
