package prototype;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019-04-12 23:08
 */
public class UnderLinePen implements Product {
    private char decorator;

    public UnderLinePen(char decorator) {
        this.decorator = decorator;
    }

    @Override
    public void use(String s) {
        System.out.println(s);
        for(int i = 0;i < s.length();i++){
            System.out.print(decorator);
        }
    }

    @Override
    public Product createInstance() {
        try {
            Product p = (Product)clone();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
