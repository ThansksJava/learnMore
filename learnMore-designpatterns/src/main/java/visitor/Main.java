package visitor;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/18 10:53
 */
public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory usr = new Directory("usr");
        File file1 = new File("file1.txt",1000);
        File file2 = new File("file2.txt",1000);
        root.add(usr);
        usr.add(file1);
        usr.add(file2);
        root.accept(new ResourceManager());
    }
}
