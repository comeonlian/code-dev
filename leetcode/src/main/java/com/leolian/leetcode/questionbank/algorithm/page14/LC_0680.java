package com.leolian.leetcode.questionbank.algorithm.page14;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * LC 680 : 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 提示:
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * <p>
 * 示例1
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 示例2
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * <p>
 * 示例3
 * 输入: s = "abc"
 * 输出: false
 */
public class LC_0680 {

	public static void main(String[] args) {
		LC_0680 lc0680 = new LC_0680();

		String s = "abccdba";
		System.out.println(lc0680.validPalindrome(s));
	}

	public boolean validPalindrome(String s) {
		AtomicInteger count = new AtomicInteger(1);
		return valid(s, 0, s.length() - 1, count);
	}

	public boolean valid(String s, int start, int end, AtomicInteger count) {
		while (start <= end) {
			char startch = s.charAt(start);
			char endch = s.charAt(end);
			if (startch != endch) {
				if (count.getAndIncrement() == 1) {
					return valid(s, start + 1, end, count) || valid(s, start, end - 1, count);
				} else {
					return false;
				}
			}
			start++;
			end--;
		}
		return true;
	}
}
