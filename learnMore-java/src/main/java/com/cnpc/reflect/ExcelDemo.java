package com.cnpc.reflect;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/9/18
 * @Time 15:27
 */
public class ExcelDemo {
    public static void main(String[] args){
        try {
            List<String>  list = new ArrayList<>();
            File excel = new File("D:/存储设备信息收集表.xlsx");
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
//            System.out.println(itr.hasNext());
            // Iterating over Excel file in Java
            while (itr.hasNext()) {
                Row row = itr.next();
//                System.out.println(row.getLastCellNum());
                // Iterating over each column of Excel file
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String value = cell.getRichStringCellValue().getString();
                    if(!"".equals(value)){
                        list.add(cell.getRichStringCellValue().getString());
                    }
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.print(cell.getStringCellValue() + "\t");
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            if(DateUtil.isCellDateFormatted(cell)){
//                                System.out.print(cell.getDateCellValue() + "\t");
//                            }else{
//                                System.out.print(cell.getNumericCellValue() + "\t");
//                            }
//
//                            break;
//                        case Cell.CELL_TYPE_BOOLEAN:
//                            System.out.print(cell.getBooleanCellValue() + "\t");
//                            break;
//                        default:
//
//                    }
                }
                System.out.println(list);
                break;
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
