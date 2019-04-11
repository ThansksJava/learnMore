package abstractfactory;

import abstractfactory.factory.Factory;
import abstractfactory.factory.Link;
import abstractfactory.factory.Page;
import abstractfactory.factory.Tray;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 14:28
 */
public class Main {
    public static void main(String[] args) {
        //具体的工厂名称
        String factoryName = "abstractfactory.concretefactory.ListFactory";
        //得到具体的工厂但是使用上转型
        Factory factory = Factory.getFactory(factoryName);
        //
        Link url1 = factory.createLink("瑞飞官网","richfit.com");
        Link url2 = factory.createLink("云管平台","cloudMarket.com");
        Tray tray = factory.createTry("中油瑞飞");
        tray.add(url1);
        tray.add(url2);

        Page page = factory.createPage("中油瑞飞","feng");
        page.add(tray);
        page.output();

    }
}
