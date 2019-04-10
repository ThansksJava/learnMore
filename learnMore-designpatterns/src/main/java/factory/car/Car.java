package factory.car;

import factory.frame.Product;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 9:59
 */
public class Car extends Product {
    public Car(String name) {
        super(name);
    }
    @Override
    public void usage() {
        System.out.println(this.name+"可以载人");
    }
}
