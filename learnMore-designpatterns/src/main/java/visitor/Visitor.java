package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 14:42
 */
public interface Visitor {
    void visit(File file);
    void visit(Dir dir);
}
