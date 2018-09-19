package com.cnpc.reflect;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/9/18
 * @Time 15:17
 */
public class Demo1 {
    public static List<String> getCode() throws Exception{
        List<String> list = new ArrayList<>();
        ServerDevice serverDevice = new ServerDevice();
        Field [] fields = serverDevice.getClass().getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            list.add(field.getName());
        }
        return list;
    }
    private static List<String> getTitles(){
        List<String>  list = new ArrayList<>();
        try {
            File excel = new File("D:/存储设备信息收集表.xlsx");
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);
            int sn = book.getNumberOfSheets();
            String name = sheet.getSheetName();
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String value = cell.getRichStringCellValue().getString();
                    if(!"".equals(value)){
                        list.add(cell.getRichStringCellValue().getString());
                    }
                }
                break;
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args)throws Exception {
        List<String> title = getTitles();
        List<String> code = getCode();
        File file = new File("title.txt");
        FileOutputStream out = new FileOutputStream(file);
        for(int i = 0;i < title.size();i++){
            StringBuilder sql = new StringBuilder();
            String codeS = code.get(i);
            sql.append("Map<String,String> "+codeS +" = new HashMap<>();\n");
            sql.append(codeS+".put(\"code\",\""+codeS+"\");\n");
            sql.append(codeS+".put(\"displayText\",\""+title.get(i)+"\");\n");
            sql.append(codeS+".put(\"filter\",\"input\")\n");
            out.write(sql.toString().getBytes());
        }
        out.close();
    }
}
