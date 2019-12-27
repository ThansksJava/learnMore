package com.learn.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/8/9
 */
public class URLT {
    public static void main(String[] args) throws IOException {
        File f = new File("unified.properties");
        System.out.println(f.getAbsoluteFile());
        URL url = new URL("file:"+f.getAbsolutePath());
        System.out.println(url);
        System.out.println(url.getPath());

        Properties properties = new Properties();
        InputStream in = url.openStream();
        properties.load(in);
        in.close();
        System.out.println(properties.getProperty("shells"));
    }
}
