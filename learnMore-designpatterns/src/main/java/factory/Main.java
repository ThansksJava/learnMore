package factory;

import factory.car.CarFactory;
import factory.frame.Factory;
import factory.frame.Product;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 10:11
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new CarFactory("小汽车生产厂");
        Product product = factory.getProduct();
        product.usage();
    }

}
