package com.leolian.leetcode.questionbank.algorithm.page06;

/**
 * LC 258 : 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * <p>
 * 示例1
 * 输入: 38
 * 输出: 2 
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class LC_0258 {

	public static void main(String[] args) {
		LC_0258 lc0258 = new LC_0258();

		int num = 38;
		System.out.println(lc0258.addDigits(num));
	}

	public int addDigits(int num) {
		if (num == 0) {
			return 0;
		}
		if ((num % 9) == 0) {
			return 9;
		}
		return num % 9;
	}
}
