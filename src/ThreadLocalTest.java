/**
 * @author GuoYangYang
 * @date 2021/11/8
 */
public class ThreadLocalTest {
    private ThreadLocal<String> content = new ThreadLocal<>();
    private ThreadLocal<Integer> num = new ThreadLocal<>();

    public String getContent() {
        return content.get();
    }

    public void setContent(String s) {
        content.set(s);
    }

    public Integer getNum() {
        return num.get();
    }

    public void setNum(Integer n) {
        num.set(n);
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        for(int i = 0 ; i < 5 ;i++){
            int ii = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.setContent(Thread.currentThread().getName()+"的数据");
                    test.setNum(ii);
                    System.out.println("=============");
                    System.out.println(Thread.currentThread().getName()+"--->"+test.getContent()+"--->"+test.getNum());
                }
            });
            t.setName("线程"+i);
            t.start();
        }
    }
}
