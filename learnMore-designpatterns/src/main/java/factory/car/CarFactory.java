package factory.car;

import factory.frame.Factory;
import factory.frame.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 9:57
 */
public class CarFactory extends Factory {
    private Product product;
    private List<Product> list = new ArrayList<>();

    public CarFactory(String factoryName) {
        super(factoryName);
    }

    @Override
    protected void createProduct() {
        System.out.println("画草图");
        product = new Car("小轿车");
        System.out.println("加工出一辆车");
    }

    @Override
    protected void registerProduct() {
        list.add(product);
    }

    @Override
    protected Product getOneProduct() {
        return product;
    }
}
