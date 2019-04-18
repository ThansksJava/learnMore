package visitor;

import java.util.Iterator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 14:43
 */
public abstract class Entry implements Element{
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws Exception{
        throw new Exception();
    }
    public Iterator iterator()throws Exception{
        throw new Exception();
    }

    @Override
    public String toString() {
        return getName()+"("+getSize()+")";
    }
}
