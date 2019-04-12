package decorator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/12 10:00
 */
public class StringDisplay extends Display{
    private String string;
    public StringDisplay(String string) {
        this.string = string;
    }
    @Override
    protected int getColumns() {
        return string.length();
    }

    @Override
    protected int getRows() {
        return 1;
    }

    @Override
    protected String getRowText(int row) {
        return string;
    }
}
