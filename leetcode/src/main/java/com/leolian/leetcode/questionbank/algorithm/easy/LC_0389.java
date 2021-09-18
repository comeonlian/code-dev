package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 389 : 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * 示例1
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例2
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例3
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例4
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 */
public class LC_0389 {

	public static void main(String[] args) {
		LC_0389 lc0389 = new LC_0389();

		String s = "ae";
		String t = "aea";
		System.out.println(lc0389.findTheDifference(s, t));
	}

	public char findTheDifference(String s, String t) {
		int as = 0, at = 0;
		for (int i = 0; i < s.length(); ++i) {
			as += s.charAt(i);
		}
		for (int i = 0; i < t.length(); ++i) {
			at += t.charAt(i);
		}
		return (char) (at - as);
	}
	
	/*
	public char findTheDifference(String s, String t) {
		if (s.length() == 0) {
			return t.charAt(0);
		}
		int[] array = new int[26];
		for (int i = 0; i < t.length(); i++) {
			array[t.charAt(i) - 97] += 1;
		}
		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i) - 97] -= 1;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				char ch = (char) (i + 97);
				return ch;
			}
		}
		return 0;
	}
	*/
}
