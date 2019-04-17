package observer;

import java.util.ArrayList;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/17 12:42
 */
public abstract class BeObserver {
    protected ArrayList<Observer> obs = new ArrayList<>();
    protected String action;
    protected void addObserver(Observer observer){
        obs.add(observer);
    }
    protected final void touchOff(){
        for(Observer ob : obs){
            ob.response(this);
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
