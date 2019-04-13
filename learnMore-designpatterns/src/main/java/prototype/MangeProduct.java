package prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * clone()方法实现的是浅克隆，即克隆的对象和原型具有相同的属性，内存地址是一样的
 * @author fengjie
 * @version 1.0
 * @date Created in 2019-04-13 15:14
 */
public class MangeProduct {
    private Map<String,Product> productMap = new HashMap<>();
    public void registProduct(String name,Product product){
        productMap.put(name,product);
    }
    public Product createProduct(String protoName){
        try {
            Product p = productMap.get(protoName);
            return p.createInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
