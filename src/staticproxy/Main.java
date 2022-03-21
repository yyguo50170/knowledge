package staticproxy;

/**
 * @author GuoYangYang
 * @date 2022/1/14
 */
public class Main {
    public static void main(String[] args) {
        UsbSell taobao = new TaoBao();
        float price =  taobao.sell(1);
        System.out.println("价格是"+price);
    }
}
