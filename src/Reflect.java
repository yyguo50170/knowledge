import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author GuoYangYang
 * @date 2021/10/29
 */
public class Reflect {
    public static void main(String[] args) throws Exception{
        Class cla = Demo.class;
        System.out.println(cla);
        Constructor constructor = cla.getConstructor();
        Object o = constructor.newInstance(1);
        System.out.println(o);
        Field[] fields = cla.getDeclaredFields();
        System.out.println("getDeclaredFields:");
        for (Field f:fields) {
            System.out.println(f);
        }
        Field[] fields1 = cla.getFields();
        System.out.println("getFields:");
        for (Field f:fields1) {
            System.out.println(f);
        }
        Method add = cla.getMethod("add",int.class,int.class);
        Object d =  cla.newInstance();
        Object res = add.invoke(d, 1, 2);
        System.out.println(res);
        Method sayHello = cla.getMethod("sayHello");
        Object invoke = sayHello.invoke(null);
        System.out.println(invoke);

    }
}

class Demo extends Super{
    private int code = 10;
    public int pcode = 20;
    public static int scode = 30;
    protected int procode = 50;

    public Demo(){
        System.out.println("午餐构造");
    }

    public Demo(int a ){
        code = a;
        System.out.println("有参数构造");
    }

    public int add(int a,int b){
        return a+b;
    }

    private int sub(int a,int b){
        return a-b;
    }

    public static void sayHello(){
        System.out.println("hello");
    }
    static class Sclass {
        public static void sayHello(){
            System.out.println("hello");
        }
    }
}

class Super{
    public int superCode = 40;
    public void superMethod(){
        return;
    }
}


