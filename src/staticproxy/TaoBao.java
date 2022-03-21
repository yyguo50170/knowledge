package staticproxy;

/**
 * @author GuoYangYang
 * @date 2022/1/14
 */
public class TaoBao implements UsbSell{

    UsbSell factory = new KingFactory();

    @Override
    public float sell(int amount) {
        float price = factory.sell(amount);
        System.out.println("赠送一个淘宝优惠券");
        return price+15;
    }
}
