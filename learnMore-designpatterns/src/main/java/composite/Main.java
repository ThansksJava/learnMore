package composite;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/14 15:37
 */
public class Main {
    public static void main(String[] args) {
        SingleFile singleFile = new SingleFile("hello.java",2);
        SingleFile singleFile1 = new SingleFile("hello1.java",3);
        Dir dir1 = new Dir("usr");
        Dir dir2 = new Dir("etc");
        dir1.add(singleFile);
        dir2.add(singleFile1);

        Dir root = new Dir("root");
        root.add(dir1);
        root.add(dir2);


        root.printList("");
    }



}
