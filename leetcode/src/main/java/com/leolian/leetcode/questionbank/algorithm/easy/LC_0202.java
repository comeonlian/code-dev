package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.HashSet;

/**
 * LC 202 : 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 提示：
 * 1 <= n <= 231 - 1
 * <p>
 * 示例1
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 示例2
 * 输入：n = 2
 * 输出：false
 */
public class LC_0202 {

    public static void main(String[] args) {
        LC_0202 lc0202 = new LC_0202();

        int n = 8;
        System.out.println(lc0202.isHappy(n));
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            set.add(n);
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            }
            n = sum;
        }
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
