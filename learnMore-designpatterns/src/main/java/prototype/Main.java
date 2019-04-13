package prototype;

import java.util.Arrays;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019-04-13 15:12
 */
public class Main {
    public static void main(String[] args) {
        MessageBox p1 = new MessageBox('%',"哈哈哈");
        Product p2 = new UnderLinePen('_');
        MangeProduct mangeProduct = new MangeProduct();
        mangeProduct.registProduct("box",p1);
        mangeProduct.registProduct("under",p2);
        MessageBox box1 = (MessageBox)mangeProduct.createProduct("box");
        MessageBox box2 = (MessageBox)mangeProduct.createProduct("box");
        Product under = mangeProduct.createProduct("under");

        System.out.println(box1==box2);
        box2.getA()[0] = 10000;

        for (int i : box1.getA()){
            System.out.println(i);
        }

    }
}
