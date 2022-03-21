package Observer;

/**
 * @author GuoYangYang
 * @date 2022/1/14
 */
public class Criminal extends Observable{
    public void steal(String location){
        String event = location+"偷东西";
        this.notifyObservers(event);
    }
}
