package mediator;

/**
 * 实现中介者的抽象定义
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/23 14:37
 */
public abstract class AbstractMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator() {
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }


    public abstract void execute(String str, Object...objs);
}
