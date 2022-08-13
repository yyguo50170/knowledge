package observer;

/**
 * @author GuoYangYang
 * @date 2022/1/14
 */
public class Police implements Observer {
    @Override
    public void update(Object event) {
        System.out.println("警察收到消息,罪犯正在" + event);
    }
}
