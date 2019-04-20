package responsibility;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/19 16:43
 */
public class SmallApproval extends Approval {
    public SmallApproval(String name, String leaderLevel) {
        super(name, leaderLevel);
    }

    @Override
    public boolean handle(RequestForLeave request) {
        if(request.getDays() <= 2){
            return true;
        }
        return false;
    }
}
