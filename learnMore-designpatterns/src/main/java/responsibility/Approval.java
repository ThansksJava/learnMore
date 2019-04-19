package responsibility;

/**
 * 请假审批者
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/19 16:36
 */
public abstract class Approval {
    protected String name;
    protected String leaderLevel;
    protected Approval nextApproval;

    public Approval(String name,String leaderLevel) {
        this.name = name;
        this.leaderLevel = leaderLevel;
    }

    public void setNextApproval(Approval nextApproval) {
        this.nextApproval = nextApproval;
    }

    public void handleTheRequest(RequestForLeave request){
        if(handle(request)){
            System.out.println("您的请假申请由"+this.name+"审批完成，发送邮件给请假人");
        }else if (nextApproval != null){
            nextApproval.handleTheRequest(request);
        }else {
            System.out.println("你这是想辞职不是想请假");
        }
    }
    public abstract boolean handle(RequestForLeave request);
}
