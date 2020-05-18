package com.example.importexcel.service.Impl;

import com.example.importexcel.dao.Heros;
import com.example.importexcel.mapper.HerosMapper;
import com.example.importexcel.service.ReadExcel;
import com.example.importexcel.utils.ImportUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ReadExcelImpl<T> implements ReadExcel<T> {

    @Autowired(required = false)
    private HerosMapper herosMapper;

    @Override
    public void read(Class clazz) throws Exception {
        FileInputStream inputStream = new FileInputStream("F:\\workspace\\一拳超人.xlsx");
        List<T> list = new ArrayList<>();
        try {

            Workbook workBook = ImportUtils.getWorkBook("xlsx", inputStream);

            //第 1页
            Sheet sheet = workBook.getSheetAt(0);

            for (int rowNum= 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                T t = (T) clazz.newInstance();
                // 行
                Row row = sheet.getRow(rowNum);
                if (null == row){
                    continue;
                }
                //组装字段   fields---多少列字段
                Field[] fields = clazz.getDeclaredFields();

                for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {

                    //单元格
                    Cell cell = row.getCell(cellNum);
                    if (null == cell) {
                        continue;
                    }
                    String cellValue = ImportUtils.getCellValue(cell);

                    for (Field field : clazz.getDeclaredFields()) {
                        com.example.importexcel.annotation.Cell ce = field.getAnnotation(com.example.importexcel.annotation.Cell.class);
                        if (null == ce) {
                            continue;
                        }
                        int cellToNum = ImportUtils.cellToNum(ce);

                        ///////////////////////////
                        // 理解 ：
                        // 将字段 与 excel中的字段一个个匹配，
                        if (cellNum  == cellToNum) {
                            field.setAccessible(true);
                            String type = field.getGenericType().toString();

                            if (type.equals("class java.lang.Integer")||type.equals("int")) {
                                field.set(t, Integer.parseInt(cellValue));
                            }else if (type.equals("class java.lang.Double")||type.equals("double")) {
                                field.set(t, Double.parseDouble(cellValue));
                            }else  if (type.equals("class java.lang.Boolean")||type.equals("boolean")) {
                                field.set(t, Boolean.parseBoolean(cellValue));
                            }else  if (type.equals("class java.util.Date")||type.equals("date")) {
                                field.set(t, DateUtil.parseYYYYMMDDDate(cellValue));
                            }else{
                                field.set(t, cellValue);
                            }
                        }
                    }
                }


                list.add(t);
            }

        }catch (Exception e){
            throw new Exception(e.getMessage(), e);
        }finally {
            inputStream.close();
        }

        // 执行导入
        log.info("开始执行导入 ：{}", list);
        insertExcelData(list);
        log.info("保存成功");

    }

    @Override
    public void readSheets() throws Exception {
        FileInputStream inputStream = null;
        String path = "F:\\workspace\\一拳超人.xlsx";
        try {
            inputStream = new FileInputStream(path);

            Workbook workbook = ImportUtils.getWorkBookBySuffix(path, inputStream);

            doReadExcel(workbook);
        }catch (Exception e){
            throw new Exception(e.getMessage(), e);
        }finally {
            inputStream.close();
        }
    }

    /**
     * 读取多 sheet页
     * @param workbook
     * @throws Exception
     */
    private void doReadExcel(Workbook workbook) throws Exception {
        int numberOfSheets = workbook.getNumberOfSheets();

        if (numberOfSheets == 0) {
            throw new Exception("excel中没有数据");
        }

        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);


        }
    }


    public void insertExcelData(List<T> list) {
        herosMapper.saveAll((List<Heros>) list);
    }
}
