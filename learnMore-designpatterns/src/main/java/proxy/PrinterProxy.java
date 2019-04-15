package proxy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/15 9:58
 */
public class PrinterProxy implements Printable {
    private String name;
    private Printable printer;

    @Override
    public synchronized void setName(String name) {
        /*
         * 当打印机不为null的时候才给打印机设置名字，被代理对象未曾初始化之前只给代理对象设置
         *
         */
        if(printer != null){
            printer.setName(name);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String someText) {
        /*
         * 未曾实例化的名字保存在代理对象中，当被代理对象创建的时候名字自然也设置了
         */
        realize();
        printer.print(someText);
    }

    /**
     * 实例化被代理对象
     */
    private synchronized void realize(){
        if(printer == null){
            printer = new Printer(name);
        }
    }
}
