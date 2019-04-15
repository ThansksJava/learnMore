package proxy;

/**
 *
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/15 9:52
 */
public interface Printable {
    /**
     * 设置打印机名称
     * @param name
     */
    void setName(String name);

    /**
     * 得到打印机名称
     * @return
     */
    String getName();

    /**
     * 执行打印方法,打印功能交给打印机，代理类做一些前置操作
     * @param someText
     */
    void print(String someText);
}
