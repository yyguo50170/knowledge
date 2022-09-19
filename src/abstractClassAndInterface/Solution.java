package abstractClassAndInterface;

public class Solution implements InterfaceDemo {

    public static void main(String[] args) {
        InterfaceImpl i = new InterfaceImpl();
        i.fly();
        System.out.println(i.sum(1, 4));
        AbstractClassDemo a = new AbstractClassDemo() {
            @Override
            public int sub(int a, int b) {
                return a - b;
            }
        };
        a.run();
        System.out.println(a.sub(5, 2));
    }

    @Override
    public void fly() {
        InterfaceDemo.super.fly();
    }

    @Override
    public int sum(int a, int b) {
        return 0;
    }
}