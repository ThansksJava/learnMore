package decorator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/12 10:01
 */
public abstract class Border extends Display{
    protected Display display;

    public Border(Display display) {
        this.display = display;
    }
}
