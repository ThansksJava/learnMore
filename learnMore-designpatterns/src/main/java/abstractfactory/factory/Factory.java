package abstractfactory.factory;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 11:01
 */
public abstract class Factory {
    public static Factory getFactory(String className){
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("没有找到对应工厂");
        }
        return factory;
    }

    /**
     * 创建链接 可以看做某产品的步骤1
     * @param caption
     * @param url
     * @return
     */
    public abstract Link createLink(String caption,String url);

    /**
     * 创建tray 可以看做产品的步骤2
     * @param caption
     * @return
     */
    public abstract Tray createTry(String caption);

    /**
     * 创建页面 可以看做产品的终极步骤
     * @param title
     * @param author
     * @return
     */
    public abstract Page createPage(String title, String author);
}
