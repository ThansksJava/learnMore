package bridge;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/16 16:49
 */
public class Main {
    public static void main(String[] args) {
        BMW bmw = new BMW();
        new BMWCorp(bmw).makeMoney();
    }
}
