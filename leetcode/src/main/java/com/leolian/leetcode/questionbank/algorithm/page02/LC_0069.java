package com.leolian.leetcode.questionbank.algorithm.page02;

/**
 * LC 69 : x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 提示：
 * 0 <= x <= 2^31 - 1
 * <p>
 * 示例1
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例2
 * 输入：x = 8
 * 输出：2
 * 解释：8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class LC_0069 {

	public static void main(String[] args) {
		LC_0069 lc0069 = new LC_0069();

		int x = 15;
		System.out.println(lc0069.mySqrt(x));
	}

	public int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		if (x < 4) {
			return 1;
		}
		int start = 0, end = x;
		int mid = 0;
		while (start < (end - 1)) {
			mid = (start + end) / 2;
			if ((x / mid) < mid) {
				end = mid;
			} else if ((x / mid) > mid) {
				start = mid;
			} else {
				return mid;
			}
		}
		return start;
	}
}
