package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 405 :  数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 * 示例1
 * 输入: 26
 * 输出: "1a"
 * <p>
 * 输入: -1
 * 输出: "ffffffff"
 */
public class LC_0405 {

	public static void main(String[] args) {
		LC_0405 lc0405 = new LC_0405();

		int num = -1;
		System.out.println(lc0405.toHex(num));
	}

	public String toHex(int num) {
		if (num == 0) {
			return String.valueOf(num);
		}
		char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		int temp = 0;
		StringBuilder builder = new StringBuilder();
		while (num != 0) {
			temp = num & 15;
			builder.insert(0, chars[temp]);
			num >>>= 4;
			System.out.println(Integer.toBinaryString(num));
		}
		return builder.toString();
	}
}
