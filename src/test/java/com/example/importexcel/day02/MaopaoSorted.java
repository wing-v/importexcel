package com.example.importexcel.day02;

import java.util.Arrays;

public class MaopaoSorted {
    public static void main(String[] args) {
        // 每次选择最大/最小值  放在数组头或尾部
        int[] arrasys = {2, 5, 1, 3, 4,6, 44,23,41,64,24,99,65,31,74};

        for (int i = 0; i < arrasys.length -1; i++) {
            int temp =0;
            for (int j = 0; j < arrasys.length -i - 1; j++) {
                if (arrasys[j] < arrasys[j + 1]) {
                    temp = arrasys[j];
                    arrasys[j] = arrasys[j + 1];
                    arrasys[j + 1] = temp;
                }
            }
        }

        System.out.println("冒泡排序后的数组： "+ Arrays.toString(arrasys));
    }
}
