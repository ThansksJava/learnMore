package visitor;

import composite.A2.FileTreatmentException;

import java.util.Iterator;
/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/18 10:25
 */
public abstract class Entry implements Element {
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public Iterator iterator() throws FileTreatmentException{
        throw new FileTreatmentException();
    }
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
