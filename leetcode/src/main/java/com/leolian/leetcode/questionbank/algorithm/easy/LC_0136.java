package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.Arrays;

/**
 * LC 136 : 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例1
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例2
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class LC_0136 {

	public static void main(String[] args) {
		LC_0136 lc0136 = new LC_0136();

		int[] nums = new int[]{4, 1, 2, 1, 2};
		System.out.println(lc0136.singleNumber(nums));
	}

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i = i + 2) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}

}
