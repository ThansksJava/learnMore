package builder;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 19:17
 */
public class Main {
    public static void main(String[] args) {
        HtmlBuilder html = new HtmlBuilder();
        MarkDownBuilder markdown = new MarkDownBuilder();
        Director mdDirector = new Director(html);
        Director htmlDirector = new Director(markdown);

        mdDirector.construct();
        htmlDirector.construct();

        html.getResult();
        markdown.getResult();
    }

}
