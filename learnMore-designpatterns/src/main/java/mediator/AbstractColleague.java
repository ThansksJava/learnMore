package mediator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/23 14:37
 */
public abstract class AbstractColleague {
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
