package abstractfactory.factory;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 10:38
 */
public abstract class Link extends Item{
    protected String url;
    public Link(String caption,String url){
        super(caption);
        this.url = url;
    }
}
