package visitor;

import java.util.Iterator;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/18 14:55
 */
public class ListVisitor implements Visitor {
    private String currentDir="";
    @Override
    public void visit(File file) {
        System.out.println(currentDir+"/"+file);
    }

    @Override
    public void visit(Dir dir) {
        System.out.println(currentDir+"/"+dir);
        String saveDir = currentDir;
        currentDir = currentDir+"/"+dir.getName();
        try {
            Iterator it = dir.iterator();
            while(it.hasNext()){
                Entry entry = (Entry)it.next();
                entry.accept(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentDir = saveDir;
    }
}
