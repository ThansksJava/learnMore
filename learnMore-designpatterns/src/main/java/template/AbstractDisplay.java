package template;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/9 20:20
 */
public abstract class AbstractDisplay {
    protected abstract void open();
    protected abstract void print();
    protected abstract void close();
    protected final void display(){
        open();
        print();
        close();
    }
}
