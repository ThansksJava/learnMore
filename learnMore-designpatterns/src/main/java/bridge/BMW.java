package bridge;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/16 16:47
 */
public class BMW implements Product {
    @Override
    public void beProducted() {
        System.out.println("一辆宝马车生产出来了");
    }

    @Override
    public void beSelled() {
        System.out.println("生产的宝马车被卖掉了");
    }
}
