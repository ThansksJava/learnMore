package abstractfactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 10:55
 */
public abstract class Page {
    protected String title;
    protected String author;
    protected List<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item){
        content.add(item);
    }
    public void output(){
        try {
            String filename = title + ".html";
            Writer writer = new FileWriter(filename);
            writer.write(this.makeHtml());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHtml();
}
