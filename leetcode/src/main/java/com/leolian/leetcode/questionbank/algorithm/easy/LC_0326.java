package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 326 : 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 示例1
 * 输入：n = 27
 * 输出：true
 * <p>
 * 示例2
 * 输入：n = 0
 * 输出：false
 * <p>
 * 示例3
 * 输入：n = 9
 * 输出：true
 * <p>
 * 示例4
 * 输入：n = 45
 * 输出：false
 */
public class LC_0326 {

    public static void main(String[] args) {
        LC_0326 lc0326 = new LC_0326();

        int n = 45;
        System.out.println(lc0326.isPowerOfThree(n));
    }

    // 1、用这个数n不断循环除以3
    public boolean isPowerOfThree(int n) {
        while ((n > 0) && (n % 3 == 0)) {
            n /= 3;
        }
        return n == 1;
    }
}
