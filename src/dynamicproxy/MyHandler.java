package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author GuoYangYang
 * @date 2021/11/1
 */
public class MyHandler implements InvocationHandler {

    private Object target = null;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = method.invoke(target,args);
        if(res != null){
            float price = (float) res;
            price += 15;
            res = price;
        }
        System.out.println("代理的价格是"+res);
        System.out.println("返回优惠券");
        return res;
    }
}
