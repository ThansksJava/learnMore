package abstractfactory.concretefactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Page;

import java.util.Iterator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 14:08
 */
public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }
    @Override
    public String makeHtml() {
        StringBuilder sql = new StringBuilder();
        sql.append("<html><head><title>");
        sql.append(title);
        sql.append("</title></head>");
        sql.append("<body>");
        sql.append("<h1>");
        sql.append(title);
        sql.append("</h1>");
        sql.append("<ul>");
        Iterator<Item> iterator = content.iterator();
        while(iterator.hasNext()){
            sql.append(iterator.next().makeHtml());
        }
        sql.append("</ul></body></html>");
        return sql.toString();
    }
}