package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 172 : 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * 提示：
 * 0 <= n <= 104
 * <p>
 * 示例1
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * <p>
 * 示例2
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * <p>
 * 示例3
 * 输入：n = 0
 * 输出：0
 */
public class LC_0172 {

	public static void main(String[] args) {
		LC_0172 lc0172 = new LC_0172();

		int n = 16;
		System.out.println(lc0172.trailingZeroes(n));
	}

	public int trailingZeroes(int n) {
		int zeroCount = 0;
		while (n > 0) {
			n /= 5;
			zeroCount += n;
		}
		return zeroCount;
	}
}
