package observer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/17 12:50
 */
public class Main {
    public static void main(String[] args) {
        BeautifulGirl girl = new BeautifulGirl("微笑");
        Man man = new Man("僚机一");
        Man man1 = new Man("僚机二");
        girl.addObserver(man);
        girl.addObserver(man1);
        girl.startAction();
    }
}
