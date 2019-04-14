package composite;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/14 15:26
 */
public class SingleFile extends Entry {
    private String name;
    private int size;

    public SingleFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    protected int getSize() {
        return size;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix+"/"+name);
    }
}
