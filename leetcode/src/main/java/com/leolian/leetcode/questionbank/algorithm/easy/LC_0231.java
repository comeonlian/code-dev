package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 231 : 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * 进阶：你能够不使用循环/递归解决此问题吗？
 * <p>
 * 示例1
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 * <p>
 * 示例2
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 * <p>
 * 示例3
 * 输入：n = 3
 * 输出：false
 * <p>
 * 示例4
 * 输入：n = 4
 * 输出：true
 * <p>
 * 示例5
 * 输入：n = 5
 * 输出：false
 */
public class LC_0231 {

	public static void main(String[] args) {
		LC_0231 lc0231 = new LC_0231();

		int n = 65536;
		System.out.println(lc0231.isPowerOfTwo(n));
	}

	public boolean isPowerOfTwo(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}
	
	/*
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		if ((n % 2) != 0) {
			return false;
		}
		while (n > 1) {
			if ((n % 2) != 0) {
				return false;
			}
			n /= 2;
		}
		return true;
	}
	*/
}
