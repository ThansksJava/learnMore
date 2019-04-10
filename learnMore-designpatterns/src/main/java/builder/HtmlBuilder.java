package builder;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 19:10
 */
public class HtmlBuilder extends Builder {
    /**
     * 使用字符串代表HTML文档
     */
    private StringBuilder html=new StringBuilder();
    @Override
    protected void makeTitle() {
        System.out.println("开始创建标题");
        html.append("<h1>标题</h1><br>");
    }

    @Override
    protected void makeBody() {
        System.out.println("开始创建内容");
        html.append("<pre>我是内容</pre>\n");
    }

    @Override
    protected void format() {
        System.out.println("开始美化");
        html.append("将这一篇文章在网页上显示的很好看\n");
    }
    public void getResult(){
        System.out.println(html.toString());
    }

}
