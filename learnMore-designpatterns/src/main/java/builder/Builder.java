package builder;

/**
 * 建造一份文档
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 19:01
 */
public abstract class Builder {
    /**
     * 创建标题
     */
    protected abstract void makeTitle();

    /**
     * 创建文章内容
     */
    protected abstract void makeBody();

    /**
     * 进行美化
     */
    protected abstract void format();
}
