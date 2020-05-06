package com.example.importexcel.day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedReadTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    }
}
