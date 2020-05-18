package com.example.importexcel.dao;

import com.example.importexcel.annotation.Cell;
import com.example.importexcel.annotation.SheetObject;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@SheetObject(sheetName = "一拳超人")
public class Heros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Cell(columnNum = "0")
    @Column
    private String name;

    @Cell(columnNum = "1")
    @Column
    private Integer age;

    @Cell(columnNum = "2")
    @Column
    private String address;

    @Cell(columnNum = "3")
    @Column
    private String job;

    @Cell(columnNum = "4")
    @Column
    private String retired;

    @Cell(columnNum = "5")
    @Column
    private Date fromdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRetired() {
        return retired;
    }

    public void setRetired(String retired) {
        this.retired = retired;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }
}