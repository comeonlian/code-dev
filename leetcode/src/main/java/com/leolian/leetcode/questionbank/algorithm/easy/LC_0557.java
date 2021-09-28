package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.Stack;

/**
 * LC 557 : 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 示例1
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc" 
 */
public class LC_0557 {

	public static void main(String[] args) {
		LC_0557 lc0557 = new LC_0557();

		String s = "Let's take LeetCode contest";
		System.out.println(lc0557.reverseWords(s));
	}

	public String reverseWords(String s) {
		if (null == s || s.length() == 0) {
			return "";
		}
		Stack<String> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				stack.push(builder.toString());
				builder = new StringBuilder();
			} else {
				builder.append(ch);
			}
		}
		if (builder.length() > 0) {
			stack.push(builder.toString());
		}
		StringBuilder sum = new StringBuilder();
		while (stack.size() > 0) {
			sum.append(stack.pop()).append(" ");
		}
		return sum.substring(0, sum.length() - 1);
	}
}
