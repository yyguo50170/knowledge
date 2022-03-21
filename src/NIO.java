import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author GuoYangYang
 * @date 2021/10/13
 */
public class NIO {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/show.txt");
            FileChannel fic = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            FileOutputStream fos = new FileOutputStream("src/show2.txt");
            FileChannel foc = fos.getChannel();
            int count = fic.read(buffer);
            while(count!=-1){
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
