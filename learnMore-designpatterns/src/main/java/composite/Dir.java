package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/14 15:28
 */
public class Dir extends Entry {
    private List<Entry> dir = new ArrayList<>();
    private String name;

    public Dir(String name) {
        this.name = name;
    }

    @Override
    public Entry add(Entry entry) throws IllegalArgumentException {
        dir.add(entry);
        return this;
    }

    @Override
    protected int getSize() {
        int size = 0;
        for(Entry entry :  dir){
            size +=entry.getSize();
        }
        return size;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix+"/"+this.getName());
        for(Entry entry :  dir){
            entry.printList(prefix+"/"+name);
        }
    }
}
