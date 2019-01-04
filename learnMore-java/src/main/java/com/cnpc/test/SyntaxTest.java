package com.cnpc.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/27 9:34
 */
public class SyntaxTest {
    @Test
    public void threeOpTest(){
        String a = null;
        System.out.println(a == null?1:Double.parseDouble(a));
    }
    @Test
    public void getSameFromTwoListTest(){
        List<String> s1=new ArrayList<>();
        s1.add("1");
        s1.add("2");
        s1.add("4");
        List<String> s2=new ArrayList<>();
        s2.add("1");
        s2.add("2");
        s2.add("3");
        s2.removeAll(s1);
        System.out.println(s2);
    }
    @Test
    public void splitTest(){
        String str = "11.11.67.30#SCAN_IP,11.11.67.39#PUBLIC_IP,11.11.67.37#VIP,11.11.67.28#SCAN_IP,11.11.67.29#SCAN_IP,";
        String [] sttrArray = str.split(",");

        String str1 = "#123";
        str1.split("#");
    }
    @Test
    public void listIsEmptyMethodTest(){
        List<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
    }

    @Test
    public void convertClassTest(){
        TestModel model = new TestModel();
        Object obj = new TestModel("fengjie");
        model = (TestModel)obj;
        model.setName("feng");
        System.out.println("finish");
    }
}
