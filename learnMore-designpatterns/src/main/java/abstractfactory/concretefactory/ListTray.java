package abstractfactory.concretefactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Tray;

import java.util.Iterator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 14:02
 */
public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }
    @Override
    public String makeHtml() {
        StringBuilder sql = new StringBuilder();
        sql.append("<li>\n");
        sql.append(caption+"\n");
        sql.append("<ul>\n");
        sql.append("<li>\n");
        Iterator<Item> iterator = tray.iterator();
        while(iterator.hasNext()){
            Item i = iterator.next();
            sql.append(i.makeHtml());
        }
        sql.append("</ul>\n");
        sql.append("</li>\n");
        return sql.toString();
    }
}
