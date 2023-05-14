package com.leolian.leetcode.questionbank.algorithm.page06;

/**
 * LC 263 : 丑数
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 示例1
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 * 示例2
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * <p>
 * 示例3
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * 示例4
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 */
public class LC_0263 {

	public static void main(String[] args) {
		LC_0263 lc0263 = new LC_0263();

		int n = 14;
		System.out.println(lc0263.isUgly(n));
	}

	// 1、首先做一些边界值判断：小于等于0的数不是丑数，1-6都是丑数
	// 2、计算 n 的所有质因数，只要有除 2 3 5 之外的质因数，就不是丑数（该方案超时）
	// 3、当 n>0 时，若 n 是丑数，则 n 可以写成 n = 2^a + 3^b + 5^c 的形式，其中 a,b,c 都是非负整数。特别地，当 a,b,c 都是 0 时，n=1
	// 4、可以对 n 反复除以 2,3,5，直到 n 不再包含质因数 2,3,5。若剩下的数等于 1，则说明 n 不包含其他质因数，是丑数；否则，说明 n 包含其他质因数，不是丑数
	public boolean isUgly(int n) {
		if (n <= 0) {
			return false;
		}
		if (n <= 6) {
			return true;
		}
		int[] factors = new int[]{2, 3, 5};
		for (int factor : factors) {
			while ((n % factor) == 0) {
				n /= factor;
			}
		}
		return n == 1;
	}
	
	/*
	时间超限: 
	for (int i = 2; i <= n; ) {
			if ((n % i) == 0) {
				if (i == 2 || i == 3 || i == 5) {
					n /= i;
				} else {
					return false;
				}
			} else {
				i++;
			}
		}
	* */
}
