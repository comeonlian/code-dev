package com.leolian.leetcode.questionbank.algorithm.page02;

/**
 * LC 53 :  最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 示例1
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例2
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例3
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例4
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例5
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class LC_0053 {

	public static void main(String[] args) {
		LC_0053 lc0053 = new LC_0053();

		int[] nums = new int[]{-2, 1};
		System.out.println(lc0053.maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int val : nums) {
			sum += val;
			if (sum < val) {
				sum = val;
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
}
