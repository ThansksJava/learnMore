package abstractfactory.factory;

/**
 * 组件里最顶层的抽象
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 10:35
 */
public abstract class Item {
    /**
     * 名称
     */
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    /**
     * 方法
     */
    public abstract String makeHtml();
}
