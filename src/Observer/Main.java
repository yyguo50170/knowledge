package Observer;

/**
 * @author GuoYangYang
 * @date 2022/1/14
 */
public class Main {
    public static void main(String[] args) {
        Criminal stealer = new Criminal();
        Police police1 = new Police(),police2 = new Police(),police3 = new Police();
        stealer.addObserver(police1);
        stealer.addObserver(police2);
        stealer.addObserver(police3);
        stealer.steal("西安");
    }
}
