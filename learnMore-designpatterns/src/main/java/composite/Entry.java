package composite;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/14 15:19
 */
public abstract class Entry {
    protected abstract int getSize();
    protected abstract String getName();

    /**
     * 如果操作对象是文件的话，由父类提供异常抛出，文件夹可以重写此方法
     * @param entry
     * @return
     * @throws IllegalArgumentException
     */
    public Entry add(Entry entry) throws IllegalArgumentException{
        throw new IllegalArgumentException("文件之中不能存放东西");
    }

    /**
     * 文件直接输出空字符串
     */
    public void printList(){
        printList("");
    }

    protected abstract void printList(String prefix);

}
