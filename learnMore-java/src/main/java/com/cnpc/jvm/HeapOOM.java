package com.cnpc.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengjie
 * @Description VM Argus -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Date Created in 2018/7/15
 * @Time 14:03
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
