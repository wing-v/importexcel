package com.example.importexcel.yanghui;

public class YangHui {
    public static void main(String[] args) {

        int row = 6;//行数
        int[][] yanghui = new int[row][row];//6行6列数组

        for (int i = 0; i < row; i++){//行
            for(int j = 0;j<= i;j++){//列
                if (j==0 || j==i){
                    // 第一个和最后一位 数字 是 1
                    yanghui[i][j]=1;

                }else{
                    // 其他位置 值 = 正上方值 + 左上方值
                    yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];
                }
                System.out.print(yanghui[i][j]+" ");
            }
            System.out.println();
        }
    }
}
