package template;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/9 20:22
 */
public class CharDisplay extends AbstractDisplay{
    private Character character;

    public CharDisplay(Character character) {
        this.character = character;
    }

    @Override
    protected void open() {
        System.out.print("<<");
    }

    @Override
    protected void print() {
        System.out.print(character);
    }

    @Override
    protected void close() {
        System.out.println(">>");
    }
}
