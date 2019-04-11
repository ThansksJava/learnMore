package abstractfactory.concretefactory;

import abstractfactory.factory.Link;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/11 13:52
 */
public class ListLink extends Link {

    public ListLink(String caption,String url){
        super(caption,url);
    }
    @Override
    public String makeHtml() {
        return "<li><a href='"+url+"'>"+caption+"</a></li>";
    }
}
