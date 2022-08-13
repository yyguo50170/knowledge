package abstractClassAndInterface;

interface InterfaceDemo {
    default void fly() {
        System.out.println("fly...");
    }

    int sum(int a, int b);

}

