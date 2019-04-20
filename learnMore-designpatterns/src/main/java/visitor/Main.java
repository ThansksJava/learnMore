package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 15:11
 */
public class Main {
    public static void main(String[] args) throws Exception{
        File singleFile = new File("hello.java",2);
        File singleFile1 = new File("hello1.java",3);
        Dir dir1 = new Dir("usr");
        Dir dir2 = new Dir("etc");
        dir1.add(singleFile).add(singleFile1);
        Dir root = new Dir("root");
        root.add(dir1);
        root.add(dir2);
        ListVisitor visitor = new ListVisitor();
        root.accept(visitor);
    }
}
