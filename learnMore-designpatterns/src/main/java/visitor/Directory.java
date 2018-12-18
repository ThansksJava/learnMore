package visitor;

import composite.A2.FileTreatmentException;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/18 10:25
 */
public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> directory = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        directory.add(entry);
        return entry;
    }

    @Override
    public String getName() {
        return name;
    }
    @SuppressWarnings("Duplicates")
    @Override
    public int getSize() {
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Iterator iterator() throws FileTreatmentException {
        return directory.iterator();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
