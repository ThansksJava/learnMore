package factory.frame;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 9:55
 */
public abstract class Factory {
    private String factoryName;

    public Factory(String factoryName) {
        this.factoryName = factoryName;
    }

    protected abstract void createProduct();
    protected abstract void registerProduct();
    protected abstract Product getOneProduct();
    public final Product getProduct(){
        createProduct();
        registerProduct();
        System.out.println("出厂一辆小汽车");
        return getOneProduct();
    }
}
