package dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author GuoYangYang
 * @date 2021/11/1
 */
public class Main {
    public static void main(String[] args) {
        UsbSell factory = new KingFactory();
        MyHandler handler = new MyHandler(factory);
        UsbSell o =(UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);
        o.sell();
    }
}
