package com.cnpc.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/27 9:34
 */
@Slf4j
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
    @Test
    public void  treeMapStringKeyTest(){
        Map<String,String> map = new TreeMap<>();
        map.put("a","a");
        map.put("b","b");
        System.out.println(map);

    }
    @Test
    public void  treeMapObjectKeyTest(){
        Map<String,String> map = new TreeMap<>();
        map.put("a","a");
        map.put("b","b");
        System.out.println(map);

    }
    /**
     * byte转为二进制输出
     */
    @Test
    public void byteTest(){
        int value =33;
        String bs =String.format("%32s",Integer.toBinaryString(value));
        System.out.println(bs);
        byte b = 8;
        String bs1 =String.format("%8s",Integer.toBinaryString(b));
        System.out.println(bs1);
        String bs2 =String.format("%8s",Integer.toBinaryString(b&0xFF));
        System.out.println(bs2);
        System.out.println("int to byte：数据发生变化");
        int i = 200;
        byte intToByte = (byte)i;
        System.out.println("intToByte:"+intToByte);
        System.out.println("byte to int:数据维持原值");
        int intToByteTOInt = intToByte;
        System.out.println("intToByteTOInt:"+intToByteTOInt);
        System.out.println("将int to byte之后的值转为原来的int值需要做高位擦除操作 即& 0xFF");
        System.out.println(intToByte& 0xFF);

    }

    /**
     * 使用小精度存储大精度，利用符号位
     */
    @Test
    public void  byteTest2(){
        //short类型因为除去符号位可用只有15位表示不下
        int i =0xFF60;// 65376
        System.out.println(i);
        // 00000000000000001111111101100000
        System.out.println(String.format("%32s",Integer.toBinaryString(i)).replace(" ","0"));
        //b1 只有i的低八位
        byte b1 =(byte) i;
        //b2 是i的倒数第二个八位，因为i先右移了八位，再转为byte再损失掉高16位
        byte b2 =(byte)(i >>8);
        //&0xFF是为了能够表示出在原来int的二进制原码中的样子
        System.out.println("b1:"+String.format("%8s",Integer.toBinaryString(b1 &0xFF)).replace(" ","0"));
        System.out.println("b2:"+String.format("%8s",Integer.toBinaryString(b2 &0xFF)).replace(" ","0"));
        int ret =(b1 &0xFF)|(b2 &0xFF)<<8;
        System.out.println("ret:"+String.format("%32s",Integer.toBinaryString(ret)).replace(" ","0"));
        System.out.println(ret);
    }

    @Test
    public void continueWhenCacheException(){
        int  n = 1;
        for(int i = 0;i < 9;i++){
            n++;
            try{
                if (i % 2 == 0){
                    int x = i / 0;
                }
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
            System.out.println("第"+(i+1)+"次循环");
        }
        System.out.println(n);
    }
    @Test
    public void booleanDefault(){
        Person person = new Person();
        if(person.isUsed()){
            System.out.println("xxxxxxxx");
        }
    }
    @Test
    public void getSimpleName() {
        Person person = new Person();
        System.out.println(person.getClass().getSimpleName());
        System.out.println(person.getClass().getName());
    }
    @Test
    public void  compress() {
        String str="我是被压缩的字符串";
        String encoding="UTF-8";
        if (str == null || str.length() == 0) {
            return;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch (IOException e) {
            log.error("gzip compress error.", e);
        }
        out.toByteArray();
    }
    @Test
    public void listClone() {
        List<String> list = new ArrayList<>(2);
        list.add("1");
        list.add("2");
        List<String> listCp = new ArrayList<>(2);
        Collections.copy(listCp,list);

        listCp.add("3");

        System.out.println(list);
    }
    @Test
    public void IntegerCacheTest() {
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);
        Integer i3 = 333;
        Integer i4 = 333;
        System.out.println(i3 == i4);
    }

    @Test
    public void objectStringConvertTest(){
        ObjectStringConvert convert = new ObjectStringConvert();
        String str = "1213124";
        convert.setContent(str);
        Object obj = convert.getContent();
        System.out.println("obj:"+obj);
        System.out.println("obj.toString:"+obj.toString());
        System.out.println("(String)obj:"+(String)obj);
    }

}
