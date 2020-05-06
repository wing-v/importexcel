package com.example.importexcel.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ImportUtils {
    public static String getCellValue(Cell cell) {
        String result = "";
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
}
