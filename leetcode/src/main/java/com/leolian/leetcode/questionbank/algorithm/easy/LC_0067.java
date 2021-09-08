package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 67 : 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 示例1
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例2
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class LC_0067 {

	public static void main(String[] args) {
		LC_0067 lc0067 = new LC_0067();

		String a = "11";
		String b = "1";
		System.out.println(lc0067.addBinary(a, b));
	}

	public String addBinary(String a, String b) {
		if ((null == a || a.length() == 0) && (null == b || b.length() == 0)) {
			return "";
		}
		if (null == a || a.length() == 0) {
			return b;
		}
		if (null == b || b.length() == 0) {
			return a;
		}
		StringBuilder builder = new StringBuilder();
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		int sum = 0, carry = 0;
		while (aIndex >= 0 || bIndex >= 0) {
			int cha = aIndex < 0 ? 0 : a.charAt(aIndex) - 48;
			int chb = bIndex < 0 ? 0 : b.charAt(bIndex) - 48;
			sum = cha + chb + carry;
			if (sum >= 2) {
				builder.append(sum - 2);
				carry = 1;
			} else {
				builder.append(sum);
				carry = 0;
			}
			aIndex--;
			bIndex--;
		}
		if (carry > 0) {
			builder.append(carry);
		}
		return builder.reverse().toString();
	}
}
