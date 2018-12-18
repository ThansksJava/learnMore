package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/18 10:26
 */
public interface Visitor {
    /**
     * 访问文件
     * @param file 要访问的文件
     */
    void visit(File file);

    /**
     * 访问文件夹
     * @param directory 要访问的文件夹
     */
    void visit(Directory directory);
}
