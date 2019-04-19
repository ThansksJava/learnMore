package responsibility;

import java.util.Random;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/19 16:52
 */
public class Main {
    public static void main(String[] args) {
        Approval mayankai = new SmallApproval("马彦楷","1");
        Approval xinglei = new MiddleApproval("邢磊","2");
        Approval fugong = new HighApproval("付长春","3");
        mayankai.setNextApproval(fugong);
        fugong.setNextApproval(xinglei);
        Random random = new Random();
        for(int i = 0;i < 40;i++){
                RequestForLeave re = new RequestForLeave("请假人"+i,"身体不舒服", i);
                mayankai.handleTheRequest(re);
            }
        }
}
