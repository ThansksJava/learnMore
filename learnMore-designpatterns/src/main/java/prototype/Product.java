package prototype;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019-04-12 22:44
 */
public interface Product extends Cloneable{
    void use(String s);
    Product createInstance();
}
