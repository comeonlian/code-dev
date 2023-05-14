package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 9 : 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * 示例1
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例2
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例3
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 示例4
 * 输入：x = -101
 * 输出：false
 */
public class LC_0009 {

    public static void main(String[] args) {
        LC_0009 lc0009 = new LC_0009();

        int x = 3;
        System.out.println(lc0009.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) { 
            return true;
        }
        if ((x % 10) == 0) {
            return false;
        }
        int y = x;
        int len = 0;
        while (y > 0) {
            y /= 10;
            len++;
        }
        int[] arr = new int[len];
        len = 0;
        while (x > 0) {
            arr[len++] = x % 10;
            x /= 10;
        }
        int start = 0, end = len - 1;
        while (start <= end) {
            int startVal = arr[start];
            int endVal = arr[end];
            if (startVal != endVal) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
