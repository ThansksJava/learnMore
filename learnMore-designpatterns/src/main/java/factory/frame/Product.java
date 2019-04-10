package factory.frame;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 9:57
 */
public abstract class Product {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract void usage();
}
