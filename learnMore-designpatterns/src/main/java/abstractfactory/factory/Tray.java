package abstractfactory.factory;

import abstractfactory.factory.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 10:52
 */
public abstract class Tray extends Item {
    protected List<Item> tray = new ArrayList<>();
    public Tray(String caption){
        super(caption);
    }
    public void add(Item item){
        tray.add(item);
    }
}
