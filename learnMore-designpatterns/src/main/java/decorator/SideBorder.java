package decorator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/12 10:03
 */
public class SideBorder extends Border {
    private Character character;
    public SideBorder(Display display,Character character) {
        super(display);
        this.character = character;
    }

    @Override
    protected int getColumns() {
        return this.display.getColumns()+2;
    }

    @Override
    protected int getRows() {
        return this.display.getRows();
    }

    @Override
    protected String getRowText(int row) {
        return character+this.display.getRowText(row)+character;
    }
}
