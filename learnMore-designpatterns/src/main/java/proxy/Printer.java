package proxy;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/15 9:59
 */
public class Printer implements Printable {
    private String name;

    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成打印机实例，需要耗费很久时间");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void print(String someText) {
        System.out.println("==="+name+"===");
        System.out.println(someText);

    }

    /**
     * 假设这个类的初始化非常耗费时间
     */
    private void heavyJob(String msg){
        System.out.println(msg);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
