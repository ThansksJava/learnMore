package observer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/17 12:41
 */
public class BeautifulGirl extends BeObserver {
    public BeautifulGirl(String action) {
        super.action = action;
    }

    public void startAction(){
        super.touchOff();
    }
}
