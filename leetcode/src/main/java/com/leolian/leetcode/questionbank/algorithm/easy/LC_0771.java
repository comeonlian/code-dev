package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.HashSet;

/**
 * LC 771 : 宝石与石头
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 注意:
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 * <p>
 * 示例1
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * <p>
 * 示例2
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 */
public class LC_0771 {

	public static void main(String[] args) {
		LC_0771 lc0771 = new LC_0771();

		String jewels = "aA";
		String stones = "aAAbbbb";
		System.out.println(lc0771.numJewelsInStones(jewels, stones));
	}

	// 1、首先将j中的字符存储到一个集合中
	// 2、再遍历s字符串中的每个字符，校验是否再j的字符集合中
	public int numJewelsInStones(String jewels, String stones) {
		if (null == jewels || jewels.length() == 0) {
			return 0;
		}
		HashSet<Character> hashSet = new HashSet<>();
		for (int i = 0; i < jewels.length(); i++) {
			char ch = jewels.charAt(i);
			hashSet.add(ch);
		}
		int count = 0;
		for (int i = 0; i < stones.length(); i++) {
			char ch = stones.charAt(i);
			if (hashSet.contains(ch)) {
				count++;
			}
		}
		return count;
	}
}
