package com.leolian.leetcode.explore.primaryalgorithm.string;

/**
 * LC 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *  
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 */
public class String002 {

    public static void main(String[] args) {
        String002 string002 = new String002();

        int x = -123;
        int reverse = string002.reverse(x);
        System.out.println(reverse);
    }

    /**
     * @param x
     * @return
     */
    public int reverse(int x) {
        /*
         此解法貌似不符合题目要求？
        执行结果：通过显示详情
        执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
        内存消耗：35.3 MB, 在所有 Java 提交中击败了94.49%的用户
        */
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
        /*
        int op = 1;
        String s = "";
        if (x >= 0) {
            op = 1;
            s = new StringBuffer(String.valueOf(x)).reverse().toString();
        } else {
            op = -1;
            s = new StringBuffer(String.valueOf(x).substring(1)).reverse().toString();
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        if (s.length() >= max.length() && s.compareTo(max) > 0) {
            return 0;
        }
        return Integer.parseInt(s) * op;

        执行结果：通过显示详情
        执行用时：3 ms, 在所有 Java 提交中击败了19.72%的用户
        内存消耗：35.7 MB, 在所有 Java 提交中击败了32.90%的用户
        */
    }


}
