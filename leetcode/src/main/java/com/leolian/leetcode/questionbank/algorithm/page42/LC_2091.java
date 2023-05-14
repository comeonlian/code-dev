package com.leolian.leetcode.questionbank.algorithm.page42;

/**
 * LC 2091 : 从数组中移除最大值和最小值
 * 给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。
 * nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。
 * 一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。
 * 返回将数组中最小值和最大值 都 移除需要的最小删除次数。
 * 提示：
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * nums 中的整数 互不相同
 * <p>
 * 示例1
 * 输入：nums = [2,10,7,5,4,1,8,6]
 * 输出：5
 * 解释：
 * 数组中的最小元素是 nums[5] ，值为 1 。
 * 数组中的最大元素是 nums[1] ，值为 10 。
 * 将最大值和最小值都移除需要从数组前面移除 2 个元素，从数组后面移除 3 个元素。
 * 结果是 2 + 3 = 5 ，这是所有可能情况中的最小删除次数。
 * <p>
 * 示例2
 * 输入：nums = [0,-4,19,1,8,-2,-3,5]
 * 输出：3
 * 解释：
 * 数组中的最小元素是 nums[1] ，值为 -4 。
 * 数组中的最大元素是 nums[2] ，值为 19 。
 * 将最大值和最小值都移除需要从数组前面移除 3 个元素。
 * 结果是 3 ，这是所有可能情况中的最小删除次数。 
 * <p>
 * 示例3
 * 输入：nums = [101]
 * 输出：1
 * 解释：
 * 数组中只有这一个元素，那么它既是数组中的最小值又是数组中的最大值。
 * 移除它只需要 1 次删除操作。
 */
public class LC_2091 {

	public static void main(String[] args) {
		LC_2091 lc2091 = new LC_2091();

		int[] nums = new int[]{2,10,7,5,4,1,8,6};
		System.out.println(lc2091.minimumDeletions(nums));
	}

	public int minimumDeletions(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		if (nums.length == 3) {
			return 2;
		}
		int maxIndex = 0, maxVal = Integer.MIN_VALUE;
		int minIndex = 0, minVal = Integer.MAX_VALUE;
		for (int i = 0; i <nums.length; i++) {
			int val = nums[i];
			if (val > maxVal) {
				maxVal = val;
				maxIndex = i;
			}
			if (val < minVal) {
				minVal = val;
				minIndex = i;
			}
		}
		if (maxIndex < minIndex) {
			int temp = maxIndex;
			maxIndex = minIndex;
			minIndex = temp;
		}
		int min = Math.min(nums.length - minIndex, maxIndex + 1);
		min = Math.min(min, minIndex + 1 + nums.length - maxIndex);
		return min;
	}
	
	/*
	执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
	内存消耗：56.7 MB, 在所有 Java 提交中击败了82.90%的用户
	通过测试用例：61 / 61
	*/
}
