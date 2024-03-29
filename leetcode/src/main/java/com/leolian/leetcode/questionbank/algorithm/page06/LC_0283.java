package com.leolian.leetcode.questionbank.algorithm.page06;

import java.util.Arrays;

/**
 * LC 283 : 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例1
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class LC_0283 {

	public static void main(String[] args) {
		LC_0283 lc0283 = new LC_0283();

		int[] nums = new int[]{0, 1, 0, 3, 12};
		System.out.println(Arrays.toString(nums));
	}

	public void moveZeroes(int[] nums) {
		if (null == nums) {
			return;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		for (int i = j; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
