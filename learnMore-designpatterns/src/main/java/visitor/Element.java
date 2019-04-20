package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 14:43
 */
public interface Element {
    void accept(Visitor visitor);
}
