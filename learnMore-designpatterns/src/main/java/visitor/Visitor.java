package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 14:42
 */
public interface Visitor {
    void accept(File file);
    void accept(Dir dir);
}
