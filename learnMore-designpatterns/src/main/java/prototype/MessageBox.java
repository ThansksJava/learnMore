package prototype;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019-04-12 23:10
 */
public class MessageBox implements Product {
    private char decorator;
    private String name;
    private int [] a  = {1,2,3};
    public MessageBox(char decorator,String name) {
        this.decorator = decorator;
        this.name = name;
    }

    @Override
    public void use(String s) {
        int length = s.length();
        for(int i = 0;i < length+2;i++){
            System.out.println(decorator);
        }
        System.out.println(decorator+s+decorator);
        for(int i = 0;i < length+2;i++){
            System.out.print(decorator);
        }

    }

    @Override
    public Product createInstance() {
        try {
            Product p = (Product) clone();
            return p;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }
}
