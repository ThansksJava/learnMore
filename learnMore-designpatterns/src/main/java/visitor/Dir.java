package visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 14:49
 */
public class Dir extends Entry {
    private String name;
    private ArrayList dir = new ArrayList();

    public Dir(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        try {
            Iterator it = iterator();
            while(it.hasNext()){
                Entry entry = (Entry) it.next();
                size+=entry.getSize();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) throws Exception {
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator iterator() throws Exception {
        return dir.iterator();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
