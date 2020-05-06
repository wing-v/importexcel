package com.example.importexcel.day02;

import java.util.Arrays;

public class quickSorted {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44};
        sort(arr, 0, arr.length - 1);

        System.out.println("快速排序后的数组 ：" + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int base = arr[left];
        int i = left, j = right;

        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (arr[j] >= base && i < j) {
                j--;  //找到后取 base左边的 下标
            }

            // 再从左往右边找，直到找到比base值大的数
            while (arr[i] <= base && i < j) {
                i++;  //找到后取base 右边的下标
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = base;

        //递归调用左半数组
        sort(arr, left, i - 1);
        //递归右边的数组
        sort(arr, i + 1, right);

    }
}
