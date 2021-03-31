package com.weakpasswd.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/3/31
 */
public class ExcelUtil {
    public static void readFromExcel(String fileName, Class clazz, AnalysisEventListener listener){
        EasyExcel.read(fileName,clazz,listener).sheet().doRead();
    }

    public static void writeToExcel(String fileName, Class clazz, List<?> data){
        ExcelWriter excelWriter = EasyExcel.write(fileName, clazz).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
        excelWriter.write(data, writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }
}
