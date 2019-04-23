package mediator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/23 14:38
 */
public class Stock extends AbstractColleague {
    /**
     * 初始电脑数量
     */
    private static int COMPUTER_NUMBER = 100;
    public Stock(AbstractMediator mediator) {
        super(mediator);
    }
    public void increase(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER +number;
        System.out.println("库存电脑数量："+ COMPUTER_NUMBER);
    }
    /**
     * 库存降低
     */
    public void decrease(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER - number;
        System.out.println("库存数量为："+COMPUTER_NUMBER);
    }
    /**
     * 获得库存数量
     */
    public int getStockNumber(){
        return COMPUTER_NUMBER;
    }

    /**
     * 需要跟采购和销售进行协调的地方，交给终结者去做
     * 相当于我想扩库，先告诉邢经理，邢经理找DBA去
     */
    public void clearStock(){
        System.out.println("清理存货数量为："+COMPUTER_NUMBER);
        super.mediator.execute("stock.clear");
    }
}
