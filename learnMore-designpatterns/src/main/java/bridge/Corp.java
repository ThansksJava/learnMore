package bridge;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/16 16:26
 */
public abstract class Corp {
    protected Product product;
    public Corp(Product product) {
        this.product = product;
    }

    protected void makeMoney(){
        product.beProducted();
        product.beSelled();
    }
}
