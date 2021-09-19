package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 728 : 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * 注意：
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 * <p>
 * 示例1
 * 输入：上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class LC_0728 {

    public static void main(String[] args) {
        LC_0728 lc0728 = new LC_0728();

        int left = 1;
        int right = 22;
        System.out.println(lc0728.selfDividingNumbers(left, right));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        if (left > right) {
            return list;
        }
        if (left == right && divide(left)) {
            list.add(left);
            return list;
        }
        for (int i = left; i <= right; i++) {
            if (i < 10) {
                list.add(i);
                continue;
            }
            if ((i % 10) == 0) {
                continue;
            }
            if (divide(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean divide(int n) {
        int x = n;
        while (x > 0) {
            int y = x % 10;
            if (y == 0) {
                return false;
            }
            if ((n % y) != 0) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
}
