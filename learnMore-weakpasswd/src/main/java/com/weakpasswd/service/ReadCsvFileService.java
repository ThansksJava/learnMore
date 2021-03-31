package com.weakpasswd.service;

import com.csvreader.CsvReader;

import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/3/31
 */
public class ReadCsvFileService {
    public static void readCsvFile(String filePath){
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath,',', Charset.forName("GBK"));

            while(reader.readRecord()){
                csvList.add(reader.getValues());
            }
            reader.close();
            System.out.println("读取的行数："+csvList.size());

            for(int row=0;row<csvList.size();row++){
                //打印每一行的数据
                System.out.print(csvList.get(row)[0]+",");
                System.out.println(csvList.get(row)[1]);

                System.out.println("-----------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
