package com.example.importexcel.day02;

import java.util.Arrays;

public class XuanzeSorted {
    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};
        // 外层循环控制循环次数
        for (int i = 0; i < arrays.length - 1; i++) {
            int min = i;
            // 内层循环的到最大值或最小值
            for (int j = i+1; j < arrays.length ; j++) {
                if (arrays[j] < arrays[min]){
                    int temp = arrays[j];
                    arrays[j] = arrays[min];
                    arrays[min] = temp;
                }
            }

        }

        System.out.println("选择排序后的数组：" + Arrays.toString(arrays));
    }
}
