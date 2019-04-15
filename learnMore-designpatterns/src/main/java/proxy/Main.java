package proxy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/15 10:22
 */
public class Main {
    public static void main(String[] args) {
        Printable printer = new PrinterProxy();
        printer.setName("冯二郎");
        printer.print("你老妈在催你找对象");
    }
}
