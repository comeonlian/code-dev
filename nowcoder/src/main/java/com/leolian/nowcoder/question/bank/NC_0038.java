package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;

/**
 * NC 38 : 螺旋矩阵
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
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        ArrayList<Integer> list = nc0038.spiralOrder(matrix);
        System.out.println(list);
    }


    public ArrayList<Integer> spiralOrder(int[][] matrix) {

        return null;
    }

}
