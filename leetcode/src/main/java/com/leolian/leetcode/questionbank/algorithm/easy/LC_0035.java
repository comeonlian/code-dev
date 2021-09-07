package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 35 :  搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 * <p>
 * 示例1
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例2
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例3
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 示例4
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * 示例5
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class LC_0035 {

	public static void main(String[] args) {
		LC_0035 lc0035 = new LC_0035();

		int[] nums = new int[]{1, 4, 6, 8, 10};
		int target = 5;
		System.out.println(lc0035.searchInsert(nums, target));
	}

	public int searchInsert(int[] nums, int target) {
		if (null == nums) {
			return -1;
		}
		if (nums.length == 0 || target <= nums[0]) {
			return 0;
		}
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return start;
	}
}
