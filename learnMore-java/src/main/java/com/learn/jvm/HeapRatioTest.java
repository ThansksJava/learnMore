package com.learn.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date 2020/10/19
 * <p>
 * -Xms600m -Xmx600m 设置堆空间的最小和最大值
 * -XX:NewRatio=2 默认老年代新生代的比例是二比一
 * -Xmn 设置新生代的空间大小，优先级比NewRatio高
 * -XX:SurvivorRatio=8 新生代 Eden:s0:s1 = 8:1:1必须明确指定此参数才能刚好这个比例
 *
 * -XX:-UseAdaptiveSizePolicy 关闭自适应内存分配（设置不管用）
 *
 * 几乎所有的对象都是在新生代Eden区创建，除非对象特别大，会直接到老年代分配
 *
 *
 * </p>
 */
public class HeapRatioTest {
    public static void main(String[] args) {
        List<HeapRatioTest> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            HeapRatioTest h = new HeapRatioTest();
            list.add(h);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
