package com.example.importexcel.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ReadExcel<T> {
    void read(Class clazz) throws Exception;

    void readSheets() throws Exception;
}
