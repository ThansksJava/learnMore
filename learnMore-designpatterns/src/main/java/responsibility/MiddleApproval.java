package responsibility;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/19 16:43
 */
public class MiddleApproval extends Approval {
    public MiddleApproval(String name, String leaderLevel) {
        super(name, leaderLevel);
    }

    @Override
    public boolean handle(RequestForLeave request) {
        if(request.getDays() > 2 && request.getDays() <= 4){
            return true;
        }
        return false;
    }
}
