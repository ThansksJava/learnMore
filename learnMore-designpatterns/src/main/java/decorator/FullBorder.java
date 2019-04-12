package decorator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/12 10:03
 */
public class FullBorder extends Border {
    private Character character;
    public FullBorder(Display display,Character character) {
        super(display);
        this.character = character;
    }
    @Override
    protected int getColumns() {
        return this.display.getColumns()+2;
    }
    @Override
    protected int getRows() {
        return this.display.getRows()+2;
    }

    @Override
    protected String getRowText(int row) {
        //下边框
        if(row==0){
            return character+makeLine(character,display.getColumns())+character;
            //上边框
        }else if(row == display.getRows()+1){
            return character+makeLine(character,display.getColumns())+character;
        }else {
            return character+display.getRowText(row-1)+character;
        }
    }

    private String makeLine(Character ch,int count){
        StringBuffer str = new StringBuffer();
        for(int i=0;i < count;i++){
            str.append(ch);
        }
        return str.toString();
    }
}
