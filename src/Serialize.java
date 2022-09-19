/**
 * @author GuoYangYang
 * @date 2022/9/19
 */

import java.io.*;

public class Serialize implements Serializable {
    int a = 2;
    transient int b = 3;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serialize s = new Serialize();
        s.a = 111;
        s.b = 2;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.txt"));
        out.writeObject(s);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.txt"));
        Object o = in.readObject();
        if (o instanceof Serialize) {
            Serialize t = (Serialize) o;
            System.out.println(t.a);
            System.out.println(t.b);
        }
        System.out.println(o);
        in.close();
    }
}