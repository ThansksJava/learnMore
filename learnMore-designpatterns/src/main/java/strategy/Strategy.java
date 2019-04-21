package strategy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/20 16:00
 */
public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
