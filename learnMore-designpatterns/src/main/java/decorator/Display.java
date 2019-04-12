package decorator;
/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/12 9:39
 */
public abstract class Display {
    protected abstract int getColumns();
    protected abstract int getRows();
    protected abstract String getRowText(int row);
    public final void show(){
        for(int i = 0;i < getRows();i++){
            System.out.println(getRowText(i));
        }
    }
}