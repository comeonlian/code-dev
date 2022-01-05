package com.leolian.nowcoder.question.bank.page05;

/**
 * NC 202 : 长度最小的连续子数组
 * 题目描述
 * 给定一个数组 nums 和一个正整数 target , 找出满足和大于等于 target 的长度最短的连续子数组并返回其长度，如果不存在这种子数组则返回 0。
 * 备注：
 * 数据范围：数组长度满足 1 <= n <= 10^5，数组中的元素满足 1 <= val <= 10^4, 1 <= target <= 10^5 
 * <p>
 * 示例1
 * 输入：[1,2,4,4,1,1,1],9
 * 返回值：3
 * <p>
 * 示例2
 * 输入：[1,4,4,4,1,1,1],3
 * 返回值：1
 */
public class NC_0202 {

	public static void main(String[] args) {
		NC_0202 nc0202 = new NC_0202();

		int[] nums = {1, 2, 4, 4, 1, 1, 1};
		int target = 14;

		System.out.println(nc0202.minSubarray2(nums, target));
	}

	/**
	 * 暴力法：从数组第一个元素开始往后计算子序列和
	 *
	 * 运行时间：227ms
	 * 超过22.92% 用Java提交的代码
	 *
	 * 占用内存：17112KB
	 * 超过12.50%用Java提交的代码
	 */
	public int minSubarray(int[] nums, int target) {
		int sum = 0;
		int minlen = 0, len = 1;
		int i = 0;
		for (int j = i; j < nums.length; j++) {
			sum += nums[j];
			if (sum >= target) {
				if (minlen == 0) {
					minlen = len;
				} else if (len <= minlen) {
					minlen = len;
				}
				sum = 0;
				len = 1;
				j = i + 1;
				i++;
			} else {
				len++;
			}
		}
		return minlen;
	}

	/**
	 * 滑动窗口：双指针控制滑动窗口得两个端点，当窗口内元素的和小于目标时就向右移动右指针，否则向右移动左指针并更新长度
	 *
	 *
	 */
	public int minSubarray2(int[] nums, int target) {
		int left = 0, right = 0;
		int sum = 0, len = nums.length;
		while (right < nums.length) {
			sum += nums[right];
			if (sum >= target) {
				len = Math.min(len, right - left);
				sum -= nums[left++];
			}
			right++;
		}
		return len == nums.length ? 0: len;
	}

}
