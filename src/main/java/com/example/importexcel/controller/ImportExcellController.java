package com.example.importexcel.controller;

import com.example.importexcel.utils.ImportUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ImportExcellController {

    @RequestMapping("/import")
    public String parseExcel() throws Exception{
        FileInputStream inputStream = new FileInputStream("F:\\workspace\\一拳超人.xlsx");

        Workbook workBook = getWorkBook("xlsx", inputStream);

        //第 1页
        Sheet sheet = workBook.getSheetAt(0);
        List<String []> list = new ArrayList<>();
        for (int rowNum= 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
            // 行
            Row row = sheet.getRow(rowNum);
            if (null == row){
                continue;
            }
            String [] rowArray = new String[row.getLastCellNum()];
            for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {

                //单元格
                Cell cell = row.getCell(cellNum);
                if (null == cell) {
                    continue;
                }
                rowArray[cellNum] = ImportUtils.getCellValue(cell);
            }
            list.add(rowArray);
        }

        // 执行导入
        doImportDataBase(list);
        return "success";
    }


    private String doImportDataBase(List<String []> list) {
        for (int i = 0; i < list.size(); i++) {
            String[] strings = list.get(i);
            System.out.println(Arrays.toString(strings));

        }
        return null;
    }

    private Workbook getWorkBook(String suffix, InputStream inputStream) throws IOException {
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
}
