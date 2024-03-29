package com.leolian.leetcode.questionbank.algorithm.page08;

/**
 * LC 383 : 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 提示：
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * 示例1
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例2
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例3
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class LC_0383 {

	public static void main(String[] args) {
		LC_0383 lc0383 = new LC_0383();

		String ransomNote = "a";
		String magazine = "b";
		System.out.println(lc0383.canConstruct(ransomNote, magazine));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		if (null == ransomNote || ransomNote.length() == 0 || null == magazine || magazine.length() == 0) {
			return false;
		}
		int[] array = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			array[magazine.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (--array[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
