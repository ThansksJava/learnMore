package template;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/9 20:27
 */
public class Main {
    public static void main(String[] args) {
        AbstractDisplay charDisplay = new CharDisplay('H');
        charDisplay.display();

        AbstractDisplay strDisplay = new StringDisplay("helloworld");
        strDisplay.display();
    }
}
