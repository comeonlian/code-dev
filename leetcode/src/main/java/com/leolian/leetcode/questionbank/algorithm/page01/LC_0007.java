package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 7 : 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * 示例1
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例2
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例3
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例4
 * 输入：x = 0
 * 输出：0
 */
public class LC_0007 {

    public static void main(String[] args) {
        LC_0007 lc0007 = new LC_0007();

        int x = 123456;
        System.out.println(lc0007.reverse(x));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int op = 1;
        int val = 0;
        if (x < 0) {
            op = -1;
            val = Math.abs(x);
        } else {
            val = x;
        }
        long result = 0;
        while (val > 0) {
            result = (result * 10) + (val % 10);
            val = val / 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        result = result * op;
        return (int) result;
    }
}
