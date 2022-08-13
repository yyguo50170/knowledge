package abstractClassAndInterface;

public class Solution {

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
}