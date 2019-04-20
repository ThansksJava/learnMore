package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 14:47
 */
public class File extends Entry{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.accept(this);
    }
}
