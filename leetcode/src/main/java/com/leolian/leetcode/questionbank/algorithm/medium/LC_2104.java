package com.leolian.leetcode.questionbank.algorithm.medium;

import org.omg.CORBA.MARSHAL;

/**
 * LC 2104 : 子数组范围和
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * 返回 nums 中 所有 子数组范围的 和 。
 * 子数组是数组中一个连续 非空 的元素序列。
 * 提示：
 * 1 <= nums.length <= 1000
 * -109 <= nums[i] <= 109
 * 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * 示例1
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0 
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 * <p>
 * 示例2
 * 输入：nums = [1,3,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [3]，范围 = 3 - 3 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,3]，范围 = 3 - 1 = 2
 * [3,3]，范围 = 3 - 3 = 0
 * [1,3,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
 * <p>
 * 示例3
 * 输入：nums = [4,-2,-3,4,1]
 * 输出：59
 * 解释：nums 中所有子数组范围的和是 59
 */
public class LC_2104 {

	public static void main(String[] args) {
		LC_2104 lc2104 = new LC_2104();

		int[] nums = new int[]{4,-2,-3,4,1};
		System.out.println(lc2104.subArrayRanges(nums));
	}

	public long subArrayRanges(int[] nums) {
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			int max = nums[i], min = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				max = Math.max(max, nums[j]);
				min = Math.min(min, nums[j]);
				sum += (max - min);
			}
		}
		return sum;
	}
	
	/*
	执行用时：18 ms, 在所有 Java 提交中击败了84.32%的用户
	内存消耗：38 MB, 在所有 Java 提交中击败了68.52%的用户
	通过测试用例：71 / 71 
	*/
	
/*
	public long subArrayRanges(int[] nums) {
		long sum = 0;
		for (int len = 0; len < nums.length; len++) {
			int left = 0, right = left + len;
			for (; right < nums.length; left++, right++) {
				if (left == right) {
					
				} else {
					int index = left;
					int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
					while (index <= right) {
						if (nums[index] > max) {
							max = nums[index];
						}
						if (nums[index] < min) {
							min = nums[index];
						}
						index++;
					}
					sum += (max - min);
				}
			}
		}
		return sum;
	}
	
	// 超时
	*/
}
