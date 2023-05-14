package com.leolian.leetcode.questionbank.algorithm.page01;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 17 : 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 示例1
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例2
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例3
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LC_0017 {

	public static void main(String[] args) {
		LC_0017 lc0017 = new LC_0017();

		String digits = "4387";
		System.out.println(lc0017.letterCombinations(digits));
	}

	private static String[][] KEYBOARD = new String[][]{
			{"", "", ""},
			{"", "", ""},
			{"a", "b", "c"},
			{"d", "e", "f"},
			{"g", "h", "i"},
			{"j", "k", "l"},
			{"m", "n", "o"},
			{"p", "q", "r", "s"},
			{"t", "u", "v"},
			{"w", "x", "y", "z"}
	};

	// 回溯
	public List<String> letterCombinations(String digits) {
		if (null == digits || digits.length() == 0) {
			return new ArrayList<>();
		}
		ArrayList<String> result = new ArrayList<>();
		String builder = "";
		backtracking(digits, 0, result, builder);
		return result;
	}

	public void backtracking(String digits, int index, ArrayList<String> result, String builder) {
		if (index == digits.length()) {
			result.add(builder);
		} else {
			String[] arr = KEYBOARD[digits.charAt(index) - 48];
			for (String s : arr) {
				backtracking(digits, index + 1, result, builder + s);
			}
		}
	}

}
