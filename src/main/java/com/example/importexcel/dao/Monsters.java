package com.example.importexcel.dao;

import com.example.importexcel.annotation.Cell;
import com.example.importexcel.annotation.SheetObject;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@SheetObject(sheetName = "怪人")
public class Monsters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Cell(columnNum = "0")
    private String name;

    @Column
    @Cell(columnNum = "1")
    private String address;

    @Column
    @Cell(columnNum = "2")
    private String job;

    @Column
    @Cell(columnNum = "3")
    private Date fromDate;
}
