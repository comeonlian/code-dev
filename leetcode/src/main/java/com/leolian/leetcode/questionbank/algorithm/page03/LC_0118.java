package com.leolian.leetcode.questionbank.algorithm.page03;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 118 : 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * https://pic.leetcode-cn.com/1626927345-DZmfxB-PascalTriangleAnimated2.gif
 * 提示:
 * 1 <= numRows <= 30
 * <p>
 * 示例1
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 示例2
 * 输入: numRows = 1
 * 输出: [[1]]
 */
public class LC_0118 {

    public static void main(String[] args) {
        LC_0118 lc0070 = new LC_0118();

        int numRows = 10;
        List<List<Integer>> res = lc0070.generate(numRows);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        int row = 1;
        while (row <= numRows) {
            ArrayList<Integer> list = new ArrayList<>(row);
            if (row == 1) {
                list.add(1);
            } else if (row == 2) {
                list.add(1);
                list.add(1);
            } else {
                list.add(1);
                List<Integer> pre = res.get(row - 2);
                for (int i = 1; i < row - 1; i++) {
                    list.add(pre.get(i - 1) + pre.get(i));
                }
                list.add(1);
            }
            res.add(list);
            row++;
        }
        return res;
    }
}
