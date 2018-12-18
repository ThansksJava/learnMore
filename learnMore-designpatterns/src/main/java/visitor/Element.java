package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/18 10:25
 */
public interface Element {
    /**
     * 通过accept将Entry放入visitor角色
     * @param visitor 具体的visitor
     */
    void accept(Visitor visitor);
}
