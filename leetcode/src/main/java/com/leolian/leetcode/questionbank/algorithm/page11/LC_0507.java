package com.leolian.leetcode.questionbank.algorithm.page11;

/**
 * LC 507 : 完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * 提示：
 * 1 <= num <= 108
 * <p>
 * 示例1
 * 输入：28
 * 输出：True
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * <p>
 * 示例2
 * 输入：num = 6
 * 输出：true
 * <p>
 * 示例3
 * 输入：num = 496
 * 输出：true
 * <p>
 * 示例4
 * 输入：num = 8128
 * 输出：true
 * <p>
 * 示例5
 * 输入：num = 2
 * 输出：false
 */
public class LC_0507 {

	public static void main(String[] args) {
		LC_0507 lc0507 = new LC_0507();

		int num = 6;
		System.out.println(lc0507.checkPerfectNumber(num));
	}

	// 先求出这个数的所有正因子，然后排除掉这个数本身
	// 然后再计算所有正因子的是否与该数相等
	public boolean checkPerfectNumber(int num) {
		if (num == 1) {
			return false;
		}
		int mid = num / 2;
		int sum = 1;
		for (int i = 2; i <= mid; i++) {
			if ((num % i) == 0) {
				sum += i;
			}
		}
		return sum == num;
	}
}
