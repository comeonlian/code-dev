package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 171 : Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 提示：
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 * <p>
 * 示例1
 * 输入: columnTitle = "A"
 * 输出: 1
 * <p>
 * 示例2
 * 输入: columnTitle = "AB"
 * 输出: 28
 * <p>
 * 示例3
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * <p>
 * 示例4
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 */
public class LC_0171 {

	public static void main(String[] args) {
		LC_0171 lc0171 = new LC_0171();

		// 'A' : 65 - 64 = 1
		// 'Z' : 90 - 64 = 26
		String columnTitle = "AB";
		System.out.println(lc0171.titleToNumber(columnTitle));
	}

	public int titleToNumber(String columnTitle) {
		if (null == columnTitle || columnTitle.length() == 0) {
			return 0;
		}
		int end = columnTitle.length() - 1;
		int pow = 0;
		int sum = 0;
		for (int i = end; i >= 0; i--) {
			char ch = columnTitle.charAt(i);
			if (ch < 'A' || ch > 'Z') {
				return 0;
			}
			sum += (ch - 64) * Math.pow(26, pow);
			pow++;
		}
		return sum;
	}
}
