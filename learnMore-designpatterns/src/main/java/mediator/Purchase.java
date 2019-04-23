package mediator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/23 14:37
 */
public class Purchase extends AbstractColleague{
    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }
    public void buyComputer(int number){
        super.mediator.execute("purchase.by",number);
    }
    public void refuseByComputer(){
        System.out.println("不再采购电脑");
    }

}
