package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;

/**
 * NC 38 : 螺旋矩阵
 * <p>
 * 题目描述
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 * <p>
 * 示例1 :
 * 输入
 * [[1,2,3],[4,5,6],[7,8,9]]
 * 返回值
 * [1,2,3,6,9,8,7,4,5]
 */
public class NC_0038 {

    public static void main(String[] args) {
        NC_0038 nc0038 = new NC_0038();

        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        ArrayList<Integer> list = nc0038.spiralOrder(matrix);
        System.out.println(list);
    }


    /**
     * 1、https://leetcode.jp/leetcode-54-spiral-matrix-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
     * <p>
     * 2、《程序员代码面试指南：IT名企算法与数据结构题目最优解》
     * 第8章：转圈打印矩阵
     * 本题在算法上没有难度，关键在于设计⼀种逻辑容易理解、代码
     * 易于实现的转圈遍历⽅式。这⾥介绍这样⼀种矩阵处理⽅式，该⽅式
     * 不仅可⽤于这道题，还适合很多其他的⾯试题，就是矩阵分圈处理。
     * 在矩阵中⽤左上⻆的坐标(tR，tC)和右下⻆的坐标(dR，dC)就可以表
     * ⽰⼀个⼦矩阵，⽐如，题⽬中的矩阵，当(tR，tC)=(0，0)、(dR，dC)=
     * (3，3)时，表⽰的⼦矩阵就是整个矩阵，那么这个⼦矩阵最外层的部
     * 分如下：
     * 1 2 3 4
     * 5    8
     * 9    12
     * 13 14 15 16
     * 如果能把这个⼦矩阵的外层转圈打印出来，那么在(tR，tC)=(0，
     * 0)、(dR，dC)=(3，3)时，打印的结果为：1，2，3，4，8，12，16，
     * 15，14，13，9，5。接下来令tR和tC加1，即(tR，tC)=(1，1)，令dR和
     * dC减1，即(dR，dC)=(2，2)，此时表⽰的⼦矩阵如下：
     * 6 7
     * 10 11
     * 再把这个⼦矩阵转圈打印出来，结果为：6，7，11，10。把tR和
     * tC加1，即(tR，tC)=(2，2)，令dR和dC减1，即(dR，dC)=(1，1)。如果
     * 发现左上⻆坐标跑到了右下⻆坐标的右⽅或下⽅，整个过程就停⽌。
     * 已经打印的所有结果连起来就是我们要求的打印结果。具体请参看如
     * 下代码中的spiralOrderPrint⽅法，其中printEdge⽅法是转圈打印⼀个⼦
     * 矩阵的外层。
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int tRow = 0;
        int tCol = 0;
        int dRow = matrix.length - 1;
        int dCol = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (tRow <= dRow && tCol <= dCol) {
            if (tRow == dRow) {
                for (int i = tCol; i <= dCol; i++) {
                    list.add(matrix[tRow][i]);
                }
            } else if (tCol == dCol) {
                for (int i = tRow; i <= dRow; i++) {
                    list.add(matrix[i][tCol]);
                }
            } else {
                int curRow = tRow;
                int curCol = tCol;
                while (curCol < dCol) {
                    list.add(matrix[tRow][curCol]);
                    curCol++;
                }
                while (curRow < dRow) {
                    list.add(matrix[curRow][dCol]);
                    curRow++;
                }
                while (curCol > tCol) {
                    list.add(matrix[dRow][curCol]);
                    curCol--;
                }
                while (curRow > tRow) {
                    list.add(matrix[curRow][tCol]);
                    curRow--;
                }
            }
            tRow++;
            tCol++;
            dRow--;
            dCol--;
        }
        return list;
    }

}
