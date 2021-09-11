package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 70 : 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例1
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例2
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class LC_0070 {

    public static void main(String[] args) {
        LC_0070 lc0070 = new LC_0070();

        int n = 5;
        System.out.println(lc0070.climbStairs(n));
    }

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int count = 4, sum = 0;
        int f1 = 2, f2 = 3;
        while (count <= n) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
            count++;
        }
        return sum;
    }
}
