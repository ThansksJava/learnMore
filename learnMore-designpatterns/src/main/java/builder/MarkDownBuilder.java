package builder;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 19:10
 */
public class MarkDownBuilder extends Builder {
    /**
     * 使用字符串代表MarkDown文档
     */
    private StringBuilder markdown = new StringBuilder();
    @Override
    protected void makeTitle() {
        System.out.println("开始创建标题");
        markdown.append("标题\n");
    }

    @Override
    protected void makeBody() {
        System.out.println("开始创建内容");
        markdown.append("我是内容\n");
    }

    @Override
    protected void format() {
        System.out.println("开始格式化文档");
        markdown.append("文档美化的很好看\n");
    }

    public void getResult(){
        System.out.println(markdown.toString());
    }

}
