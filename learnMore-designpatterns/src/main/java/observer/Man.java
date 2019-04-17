package observer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/17 12:46
 */
public class Man implements Observer {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void response(BeObserver observer) {
        System.out.println(this.name+":报告大王那个姑娘开始"+observer.getAction());
    }
}
