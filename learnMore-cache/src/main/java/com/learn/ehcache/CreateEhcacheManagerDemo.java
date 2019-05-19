package com.learn.ehcache;
import net.sf.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/6/30
 * @Time 19:07
 */
public class CreateEhcacheManagerDemo {
    private static Logger logger = LoggerFactory.getLogger(CreateEhcacheManagerDemo.class);
    public static void main(String[] args) {
        String [] cacheNames = CacheManager.create().getCacheNames();
        for (String s:
             cacheNames) {
            logger.debug(s);
        }


    }
}
