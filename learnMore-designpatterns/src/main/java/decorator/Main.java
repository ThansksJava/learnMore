package decorator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/12 10:12
 */
public class Main {
    public static void main(String[] args) {
        Display b = new StringDisplay("helloworld");
        b.show();
        System.out.println("两边各加一个符号：");
        Display bp = new SideBorder(b,'#');
        bp.show();
        System.out.println("再包一层符号：");
        Display bpp = new FullBorder(bp,'-');
        bpp.show();
        System.out.println("再包一层符号：");
        Display bppp = new SideBorder(bpp,'*');
        bppp.show();
        System.out.println("再来一层");
        Display bpppp = new FullBorder(bppp,'$');
        bpppp.show();
    }
}
