package template;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/9 20:23
 */
public class StringDisplay extends AbstractDisplay {
    private String str;

    public StringDisplay(String str) {
        this.str = str;
    }

    @Override
    protected void open() {
        printLn();
    }

    @Override
    protected void print() {
        System.out.print("|"+str+"|");
        System.out.println();
    }

    @Override
    protected void close() {
        printLn();
    }
    private void printLn(){
        System.out.print("+");
        for(int i = 0;i < str.toCharArray().length;i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
