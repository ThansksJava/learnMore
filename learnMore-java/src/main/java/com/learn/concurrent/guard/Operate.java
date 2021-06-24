package com.learn.concurrent.guard;

import java.util.concurrent.TimeUnit;

public class Operate {

    public static String dbOprate(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result";
    }


}
