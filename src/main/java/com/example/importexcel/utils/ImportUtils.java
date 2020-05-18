package com.example.importexcel.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.jdbc.Work;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ImportUtils {
    // 读取的数据全部转换成 string类型
    public static String getCellValue(Cell cell) {
        String result;
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getStringCellValue();
                break;
            case BLANK:
                result = "";
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // 日期
                    SimpleDateFormat sf  = new SimpleDateFormat("yyyy-MM-dd");
                    result = sf.format(cell.getDateCellValue());
                }else {
                    //数字
                    double numericCellValue = cell.getNumericCellValue();
                    // 数字格式化保留几位小数
                    DecimalFormat decimalFormat = new DecimalFormat();
                    decimalFormat.applyPattern("#");
                    result = decimalFormat.format(numericCellValue);
                }
                break;
                default:
                    result = "";
        }
        return result;
    }

    // 根据后缀返回woriBook对象
    public static Workbook getWorkBookBySuffix(String path, InputStream inputStream) throws Exception {
        Workbook workbook;
        if (path.endsWith("xls")){
            workbook = new XSSFWorkbook(inputStream);
        }else if (path.endsWith("xlsx")){
            workbook = new HSSFWorkbook(inputStream);
        }else {
            throw new Exception("要解析的 Excel文件必须是 xls 或 xlsx 结尾");
        }
        return workbook;
    }

    public static Workbook getWorkBook(String suffix, InputStream inputStream) throws IOException {
        Workbook workbook ;
        if ("xlsx".equals(suffix)) {
            workbook = new XSSFWorkbook(inputStream);
        }else if ("xls".equals(suffix)) {
            workbook = new HSSFWorkbook(inputStream);
        }else {
            return null;
        }
        return workbook;
    }

    // 将字母 转换成 数组   A -- 1
    public static int cellToNum(com.example.importexcel.annotation.Cell ce){
        String columnNum = ce.columnNum();
//        int num = 0;
//        int number = 0;
//        if (null != ce && !("".equals(ce))) {
//            for(int i = 0; i < columnNum.length(); i++) {
//                char ch = columnNum.charAt(columnNum.length() - i - 1);
//                num = (int)(ch - 'A' + 1) ;
//                num *= Math.pow(26, i);
//                number += num;
//            }
//        }
//        return number;
        return Integer.parseInt(columnNum);
    }
}
