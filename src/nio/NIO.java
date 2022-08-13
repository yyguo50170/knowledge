package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author GuoYangYang
 * @date 2021/10/13
 */
public class NIO {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/nio/show.txt");
            FileChannel fic = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            FileOutputStream fos = new FileOutputStream("src/nio/show2.txt");
            FileChannel foc = fos.getChannel();
            int count = fic.read(buffer);
            while (count != -1) {
                buffer.flip();  //将buffer的数据写入channel之前需要执行的操作
                foc.write(buffer);
                buffer.clear(); //要将channel的数据读入buffer之前需要执行的操作
                count = fic.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
