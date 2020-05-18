package com.example.importexcel.controller;

import com.example.importexcel.dao.Heros;
import com.example.importexcel.service.ReadExcel;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excel")
public class ImportExcellController {

    @Autowired
    private ReadExcel readExcel;

    /**
     *  单张表导入
     */
    @RequestMapping("/import")
    public String parseExcel() throws Exception{
        readExcel.read(Heros.class);
        return "success";
    }

    /**
     * 多sheet 导入
     */
    public String parseExcels(){
//        readExcel.readSheets();
        try {
            Thread thread  = new Thread();
            thread.sleep(222);
            thread.wait();
        }catch (Exception e){

        }
        return "success";
    }
}
