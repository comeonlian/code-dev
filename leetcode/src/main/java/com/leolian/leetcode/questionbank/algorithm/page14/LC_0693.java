package com.leolian.leetcode.questionbank.algorithm.page14;

/**
 * LC 693 : 交替位二进制数
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * 示例1
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * <p>
 * 示例2
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * <p>
 * 示例3
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 * 示例4
 * 输入：n = 10
 * 输出：true
 * 解释：10 的二进制表示是：1010.
 * <p>
 * 示例5
 * 输入：n = 3
 * 输出：false
 */
public class LC_0693 {

	public static void main(String[] args) {
		LC_0693 lc0693 = new LC_0693();

		int n = 5;
		System.out.println(lc0693.hasAlternatingBits(n));
	}

	public boolean hasAlternatingBits(int n) {
		int x = n;
		int cur = -1, pre = -1;
		while (x > 0) {
			if (cur != -1) {
				pre = cur;
			}
			cur = x & 1;
			if (cur == pre) {
				return false;
			}
			x >>>= 1;
		}
		return true;
	}
}
