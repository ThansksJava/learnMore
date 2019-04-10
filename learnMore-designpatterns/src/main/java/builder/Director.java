package builder;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/10 19:18
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle();
        builder.makeBody();
        builder.format();
    }
}
